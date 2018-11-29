package net.meloli.demo.sys.service.impl;

import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.mongodb.util.MongoDBUtils;
import net.meloli.demo.sys.service.inf.IBlogService;
import net.meloli.demo.sys.util.IdWorker;
import net.meloli.demo.sys.util.MvcDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("blogService")
@Transactional
public class BlogServiceImpl implements IBlogService {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 获取博客列表
     *
     * @return MvcDataDto
     */
    @Override
    public MvcDataDto getBlogList() {
        MvcDataDto data = MvcDataDto.getInstance();
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "blogPublishDate"));
        List<Blog> blogList = mongoTemplate.find(query, Blog.class, MongoDBUtils.CollectionName.BLOG);
        data.setResultObj(blogList);
        data.setResultCode(MvcDataDto.SUCCESS);
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
    public MvcDataDto getBlogDetail(String id) {
        MvcDataDto data = MvcDataDto.getInstance();
        Query query = new Query();
        query.addCriteria(Criteria.where("blogId").is(id));
        Blog detail = mongoTemplate.findOne(query, Blog.class);
        data.setResultObj(detail);
        data.setResultCode(MvcDataDto.SUCCESS);
        return data;
    }
}
