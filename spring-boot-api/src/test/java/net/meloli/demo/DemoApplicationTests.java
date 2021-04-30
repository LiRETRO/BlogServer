package net.meloli.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.meloli.demo.sys.controller.BlogController;
import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.entity.Tag;
import net.meloli.demo.sys.mapper.IBlogMapper;
import net.meloli.demo.sys.mapper.ITagsMapper;
import net.meloli.demo.sys.mongodb.util.MongoDBUtils;
import net.meloli.demo.sys.rabbitmq.service.IProducerService;
import net.meloli.demo.sys.service.inf.ITagsService;
import net.meloli.demo.sys.util.IdWorker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {

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

    @Test
    public void idWorkerTest() {
        Logger logger = Logger.getLogger(this.getClass().getSimpleName());
        logger.log(Level.INFO, "普通Date测试");
        logger.log(Level.INFO, IdWorker.getDateId());
        logger.log(Level.INFO, "Id测试");
        logger.log(Level.INFO, IdWorker.getId());
        logger.log(Level.INFO, "FullDate测试");
        logger.log(Level.INFO, IdWorker.getFullDateId());
    }

    @Autowired
    ITagsMapper tagsMapper;

    @Test
    public void myBatisTest() {
        PageHelper.startPage(1, 5);
        List<Tag> list = tagsMapper.getTags();
        PageInfo<Tag> pageInfo = new PageInfo<>(list);
        Assert.assertEquals(pageInfo.getTotal(), 0);
    }

    @Autowired
    ITagsService tagsService;

    @Test
    public void addTag() throws Exception {
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag().setTagName("Liunx"));
        tags.add(new Tag().setTagName("Redis"));
        tagsService.addTags(tags);
    }

    @Autowired
    IBlogMapper iBlogMapper;

    @Test
    public void insertToMysqlFromMongodb() {
//        Query query = new Query();
//        query.with(new Sort(Sort.Direction.DESC, "blogPublishDate"));
//        query.skip(0);
//        query.limit(20);
//        List<Blog> blogList = mongoTemplate.find(query, Blog.class, MongoDBUtils.CollectionName.BLOG);
//        System.out.println(blogList);
    }

    @Test
    public void getBlogList() {
        PageHelper.startPage(1, 1);
        List<Blog> blogs = iBlogMapper.getBlogList(null);
        Assert.assertEquals(1l, blogs.size());
    }

}
