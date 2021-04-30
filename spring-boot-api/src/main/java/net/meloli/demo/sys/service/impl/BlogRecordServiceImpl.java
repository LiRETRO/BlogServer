package net.meloli.demo.sys.service.impl;

import net.meloli.demo.sys.dto.VisitDto;
import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.entity.BlogRecord;
import net.meloli.demo.sys.mongodb.util.MongoDBUtils;
import net.meloli.demo.sys.service.inf.IBlogRecordService;
import net.meloli.demo.sys.util.IdWorker;
import org.springframework.stereotype.Service;

@Service("blogRecordService")
public class BlogRecordServiceImpl implements IBlogRecordService {

//    @Autowired
//    MongoTemplate mongoTemplate;


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
//        BlogRecord record = mongoTemplate.findOne(new Query().addCriteria(Criteria.where("visitIp").is(visitDto.getIpAddr())), BlogRecord.class, MongoDBUtils.CollectionName.BLOG_RECORD);
//        if (record != null) {
//            return false;
//        }
//        BlogRecord blogRecord = new BlogRecord();
//        blogRecord.setRecordId(IdWorker.getDateId());
//        blogRecord.setBlogId(visitDto.getBlogId());
//        blogRecord.setVisitTime(visitDto.getRequestTime());
//        blogRecord.setVisitIp(visitDto.getIpAddr());
//        Query query = new Query();
//        query.addCriteria(Criteria.where("blogId").is(visitDto.getBlogId()));
//        synchronized (visitDto.getBlogId().intern()) {
//            Blog detail = mongoTemplate.findOne(query, Blog.class);
//            Long blogVisitedCount = detail.getBlogVisitedCount() == null ? 0 : detail.getBlogVisitedCount();
//            Update update = Update.update("blogVisitedCount", blogVisitedCount + 1);
//            mongoTemplate.save(blogRecord, MongoDBUtils.CollectionName.BLOG_RECORD);
//            mongoTemplate.updateFirst(query, update, MongoDBUtils.CollectionName.BLOG);
//        }
        return true;
    }
}
