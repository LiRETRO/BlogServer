package net.meloli.demo.sys.service.impl;

import com.alibaba.fastjson.JSON;
import net.meloli.demo.sys.dto.VisitDto;
import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.mongodb.util.MongoDBUtils;
import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import net.meloli.demo.sys.rabbitmq.service.IProducerService;
import net.meloli.demo.sys.service.inf.IBlogService;
import net.meloli.demo.sys.util.IdWorker;
import net.meloli.demo.sys.util.MvcDataDto;
import net.meloli.demo.sys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service("blogService")
@Transactional
public class BlogServiceImpl implements IBlogService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    IProducerService iProducerService;

    /**
     * 获取博客列表
     *
     * @return MvcDataDto
     */
    @Override
    public MvcDataDto<List<Blog>> getBlogList(MvcDataDto param) {
        MvcDataDto<List<Blog>> data = MvcDataDto.getInstance();
        Page page = param.getPage();
        if (page != null) {
            Query query = new Query();
            query.with(new Sort(Sort.Direction.DESC, "blogPublishDate"));
            Long skip = (long)(page.getPageNum() - 1) * page.getPageSize();
            query.skip(skip);
            query.limit(page.getPageSize());
            Long totalNum = mongoTemplate.count(new Query(), MongoDBUtils.CollectionName.BLOG);
            page.setTotalNum(totalNum);
            List<Blog> blogList = mongoTemplate.find(query, Blog.class, MongoDBUtils.CollectionName.BLOG);
            blogList = blogList.stream()
                    .peek(item -> item.setBlogContent(item.getBlogContent().replaceAll("<[^>]*>", "")))
                    .collect(Collectors.toList());
            data.setPage(page);
            data.setResultObj(blogList);
            data.setResultCode(MvcDataDto.SUCCESS);
        }
        return data;
    }

    /**
     * 添加博客
     *
     * @return
     */
    @Override
    public MvcDataDto addBlog(Blog blog) {
        MvcDataDto data = MvcDataDto.getInstance();
        blog.setBlogId(IdWorker.getId());
        blog.setBlogIsDel(false);
        blog.setBlogPublishDate(new Date());
        blog.setBlogVisitedCount(0L);
        blog.setBlogPublisher("LiRETRO");
        blog.setBlogPublisherCode("");
        mongoTemplate.save(blog, MongoDBUtils.CollectionName.BLOG);
        data.setResultCode(MvcDataDto.SUCCESS);
        data.setResultMessage("发布博客成功！");
        return data;
    }

    /**
     * 获取博客列表
     * @return MvcDataDto
     */
    @Override
    public MvcDataDto<Blog> getBlogDetail(String id) {
        MvcDataDto<Blog> data = MvcDataDto.getInstance();
        Query query = new Query();
        query.addCriteria(Criteria.where("blogId").is(id));
        Blog detail = mongoTemplate.findOne(query, Blog.class, MongoDBUtils.CollectionName.BLOG);
        Long blogVisitedCount = detail.getBlogVisitedCount() == null ? 0L : detail.getBlogVisitedCount();
        detail.setBlogVisitedCount(blogVisitedCount + 1);
        // 新增一条访问记录, 并推送到消息队列
        VisitDto visitDto = new VisitDto(id, new Date());
        iProducerService.send(RabbitMQConfig.QUEUE, JSON.toJSONString(visitDto));
        data.setResultObj(detail);
        data.setResultCode(MvcDataDto.SUCCESS);
        return data;
    }

    /**
     * 删除博客
     * @param blogId
     * @return
     */
    @Override
    public MvcDataDto deleteBlog(String blogId) {
        MvcDataDto data = MvcDataDto.getInstance();
        Query query = new Query();
        query.addCriteria(Criteria.where("blogId").is(blogId));
        mongoTemplate.remove(query, MongoDBUtils.CollectionName.BLOG);
        data.setResultCode(MvcDataDto.SUCCESS);
        data.setResultMessage("删除成功！");
        return data;
    }
}
