package net.meloli.demo;

import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.mongodb.util.MongoDBUtils;
import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import net.meloli.demo.sys.rabbitmq.service.IProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    IProducerService iProducerService;

 /*   @Test
    public void contextLoads() {
        Blog blog = new Blog();
        blog.setBlogId("TEST_123456");
        blog.setBlogTitle("测试标题");
        blog.setBlogContent("测试正文");
        blog.setBlogPublisher("Administrator");
        blog.setBlogPublisherCode("Administrator");
        blog.setBlogPublishDate(new Date());
        blog.setBlogIsDel(false);
        mongoTemplate.save(blog, MongoDBUtils.CollectionName.BLOG);
    }*/

/*    @Test
    public void rabbitMQTest() {
        // 循环发送消息，测试接收者是否可以接收到
        for(int i = 0, len = 10; i < len; ++i ) {
            iProducerService.send(RabbitMQConfig.QUEUE, "测试RabbitMQ消息，这是第" + (i + 1) + "条");
        }
    }*/

}
