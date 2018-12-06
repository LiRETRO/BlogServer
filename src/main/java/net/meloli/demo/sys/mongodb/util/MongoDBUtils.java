package net.meloli.demo.sys.mongodb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * MongoDB 工具类
 * 使用MongoTemplate
 * @author LiRETRO
 */
@Component
public abstract class MongoDBUtils {

    /**
     * 集合名称
     */
    public static class CollectionName {
        // 博客
        public static final String BLOG = "blog";
        // 博客访问记录
        public static final String BLOG_RECORD = "blog_record";
        // 全局异常
        public static final String GLOBAL_EXCEPTION_INFO = "global_exception_info";
    }
}
