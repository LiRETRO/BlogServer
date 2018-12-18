package net.meloli.demo;

import net.meloli.demo.sys.controller.BlogController;
import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.mongodb.util.MongoDBUtils;
import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import net.meloli.demo.sys.rabbitmq.service.IProducerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    IProducerService iProducerService;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new BlogController()).build();
    }

    @Test
    public void testBlogController() {
        RequestBuilder request = null;
    }

/*    @Test
    public void contextLoads() {
        Blog blog = new Blog();
        blog.setBlogId("TEST_123456");
        blog.setBlogTitle("关于RabbitMQ在Liunx下的部署");
        blog.setBlogContent("关于RabbitMQ在Liunx下的部署关于RabbitMQ在Liunx下的部署关于RabbitMQ在Liunx下的部署关于RabbitMQ在Liunx下的部署关于RabbitMQ在Liunx下的部署关于RabbitMQ在Liunx下的部署关于RabbitMQ在Liunx下的部署关于RabbitMQ在Liunx下的部署关于RabbitMQ在Liunx下的部署");
        blog.setBlogPublisher("LiRETRO");
        blog.setBlogPublisherCode("LiRETRO");
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
