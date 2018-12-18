package net.meloli.demo.sys.service.impl;

import net.meloli.demo.sys.dto.VisitDto;
import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.entity.BlogRecord;
import net.meloli.demo.sys.mongodb.util.MongoDBUtils;
import net.meloli.demo.sys.service.inf.IBlogRecordService;
import net.meloli.demo.sys.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service("blogRecordService")
public class BlogRecordServiceImpl implements IBlogRecordService {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 保存博客访问记录
     *
     * @param visitDto
     * @return
     */
    @Override
    public boolean saveBlogVisitRecord(VisitDto visitDto) {
        if (visitDto == null || "".equals(visitDto.getBlogId())) {
            return false;
        }
        BlogRecord blogRecord = new BlogRecord();
        blogRecord.setRecordId(IdWorker.getDateId());
        blogRecord.setBlogId(visitDto.getBlogId());
        blogRecord.setVisitTime(visitDto.getRequestTime());
        Query query = new Query();
        query.addCriteria(Criteria.where("blogId").is(visitDto.getBlogId()));
        Blog detail = mongoTemplate.findOne(query, Blog.class);
        Long blogVisitedCount = detail.getBlogVisitedCount() == null ? 0 : detail.getBlogVisitedCount();
        Update update = Update.update("blogVisitedCount", blogVisitedCount + 1);
        mongoTemplate.save(blogRecord, MongoDBUtils.CollectionName.BLOG_RECORD);
        mongoTemplate.updateFirst(query, update, MongoDBUtils.CollectionName.BLOG);
        return true;
    }
}
