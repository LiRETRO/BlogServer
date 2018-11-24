package net.meloli.demo.sys.service.impl;

import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.mongodb.util.MongoDBUtils;
import net.meloli.demo.sys.service.inf.IBlogService;
import net.meloli.demo.sys.util.MvcDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public MvcDataDto addBlog() {

        return null;
    }
}
