package net.meloli.demo.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import net.meloli.demo.sys.dto.BlogPrevAndNextDTO;
import net.meloli.demo.sys.dto.BlogSearchConditionDTO;
import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.mapper.IBlogMapper;
import net.meloli.demo.sys.rabbitmq.service.IProducerService;
import net.meloli.demo.sys.service.inf.IBlogService;
import net.meloli.demo.sys.util.IdWorker;
import net.meloli.demo.sys.util.MvcDataDto;
import net.meloli.demo.sys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("blogService")
@Transactional(rollbackFor = Exception.class)
public class BlogServiceImpl implements IBlogService {

    private IBlogMapper iBlogMapper;

    @Autowired
    public BlogServiceImpl (IBlogMapper iBlogMapper) {
        this.iBlogMapper = iBlogMapper;
    }

    /**
     * 获取博客列表
     * @MethodName: getBlogList
     * @Param: [param]
     * @Return: net.meloli.demo.sys.util.MvcDataDto<java.util.List<net.meloli.demo.sys.entity.Blog>>
     * @Exception
     * @Author: LiRETRO
     * @Date: 19-11-5
    **/
    @Override
    public MvcDataDto<List<Blog>> getBlogList(MvcDataDto param) {
        MvcDataDto<List<Blog>> data = MvcDataDto.getInstance();
        Page page = param.getPage();
        if (page != null) {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            JSONObject jsonObject = new JSONObject((Map<String, Object>) param.getParam());
            BlogSearchConditionDTO searchConditionDTO = JSON.toJavaObject(jsonObject, BlogSearchConditionDTO.class);
            List<Blog> blogs = iBlogMapper.getBlogList(searchConditionDTO);
            /**
             * 只有在完全查询时才过滤博客正文
             * 简单查询时不会查询blogContent字段
             **/
            if (searchConditionDTO.getSearchType() == 1) {
                blogs = blogs.stream()
                        .peek(item -> item.setBlogContent(item.getBlogContent().replaceAll("<[^>]*>", "")))
                        .collect(Collectors.toList());
            }
            data.setPage(page);
            data.setData(blogs);
            data.setCode(HttpStatus.OK.value());
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
        blog.setBlogIsDel(false);
        blog.setBlogPublishDate(new Date());
        blog.setBlogVisitedCount(0L);
        blog.setBlogPublisher("LiRETRO");
        blog.setBlogPublisherCode("");
        int record = iBlogMapper.insert(blog);
//        mongoTemplate.save(blog, MongoDBUtils.CollectionName.BLOG);
        if (record == 1) {
            data.setCode(HttpStatus.OK.value());
            data.setMessage("发布博客成功！");
        }
        return data;
    }

    /**
     * 获取博客列表
     * @return MvcDataDto
     */
    @Override
    public MvcDataDto<Blog> getBlogDetail(String id) {
        MvcDataDto<Blog> data = MvcDataDto.getInstance();
        /*Query query = new Query();
        query.addCriteria(Criteria.where("blogId").is(id));
        Blog detail = mongoTemplate.findOne(query, Blog.class, MongoDBUtils.CollectionName.BLOG);
        VisitDto visitDto = new VisitDto(id, new Date(), IpUtils.getRemoteIp(servletRequest));
        iProducerService.send(RabbitMQConfig.QUEUE, JSON.toJSONString(visitDto));*/
        Blog detail = iBlogMapper.getBlogDetail(id);
        data.setData(detail);
        data.setCode(HttpStatus.OK.value());
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
        /*Query query = new Query();
        query.addCriteria(Criteria.where("blogId").is(blogId));
        mongoTemplate.remove(query, MongoDBUtils.CollectionName.BLOG);*/
        int num = iBlogMapper.deleteBlog(blogId);
        data.setCode(HttpStatus.OK.value());
        data.setMessage("删除成功！");
        return data;
    }

    /**
     * 通过当前博客的Id获取上/下一条博客
     *
     * @param blogId
     * @return
     */
    @Override
    public MvcDataDto<BlogPrevAndNextDTO> getBlogPrevAndNext(String blogId) {
        MvcDataDto<BlogPrevAndNextDTO> data = MvcDataDto.getInstance();
        BlogPrevAndNextDTO blogPrevAndNextDTO = new BlogPrevAndNextDTO();
        List<Blog> prevAndNext = iBlogMapper.getPrevAndNext(blogId);
        if (!CollectionUtils.isEmpty(prevAndNext)) {
            prevAndNext.forEach(blog -> {
                if (blog.getId() > Long.parseLong(blogId)) {
                    blogPrevAndNextDTO.setNext(blog);
                } else {
                    blogPrevAndNextDTO.setPrev(blog);
                }
            });
        }
        /*// 上一条
        Query lastOne = new Query();
        lastOne.addCriteria(Criteria.where("blogId").lt(blogId)).with(new Sort(Sort.Direction.DESC, "blogId")).limit(1);
        Blog lastOneBlog = mongoTemplate.findOne(lastOne, Blog.class, MongoDBUtils.CollectionName.BLOG);
        blogPrevAndNextDTO.setPrev(lastOneBlog);
        // 下一条
        Query nextOne = new Query();
        nextOne.addCriteria(Criteria.where("blogId").gt(blogId)).with(new Sort(Sort.Direction.ASC, "blogId")).limit(1);
        Blog nextOneBlog = mongoTemplate.findOne(nextOne, Blog.class, MongoDBUtils.CollectionName.BLOG);
        blogPrevAndNextDTO.setNext(nextOneBlog);*/
        data.setCode(HttpStatus.OK.value());
        data.setMessage("成功");
        data.setData(blogPrevAndNextDTO);
        return data;
    }
}
