package net.meloli.demo.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.meloli.demo.sys.base.BaseController;
import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import net.meloli.demo.sys.rabbitmq.service.IProducerService;
import net.meloli.demo.sys.service.inf.IBlogService;
import net.meloli.demo.sys.util.MvcDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "博客接口", tags = "BlogController")
@RestController
@RequestMapping("/api/blog")
public class BlogController extends BaseController {

    @Autowired
    IBlogService iBlogService;

    @Autowired
    IProducerService iProducerService;

    @ApiOperation(value = "发送RbbitMQ消息测试", notes = "发送RabbitMQ消息测试")
    @GetMapping(value = "/sendMsgTest")
    public void sendMsgTest() {
        // 循环发送消息，测试接收者是否可以接收到
        for(int i = 0, len = 10; i < len; ++i ) {
            iProducerService.send(RabbitMQConfig.TEST_QUEUE, "测试RabbitMQ消息，这是第" + (i + 1) + "条");
        }
    }

    @ApiOperation(value = "异常测试", notes = "异常测试中")
    @GetMapping(value = "/exceptionTest")
    public void exceptionTest() throws Exception {
        throw new Exception("异常测试");
    }

    @ApiOperation(value = "获取博客单条详情", notes = "通过ID获取博客详情")
    @GetMapping(value = "/getBlogDetail/{blogId}")
    public Object getBlogDetail(@PathVariable String blogId) {
        return iBlogService.getBlogDetail(blogId);
    }

    @ApiOperation(value = "获取博客List", notes = "获取博客List")
    @PostMapping(value = "/getBlogList", consumes = "application/json")
    public Object getBlogList(@RequestBody MvcDataDto param) {
        return iBlogService.getBlogList(param);
    }

    @ApiOperation(value = "发布博客", notes = "发布博客")
    @PostMapping(value = "/addBlog")
    public Object addBlog(Blog blog) {
        return iBlogService.addBlog(blog);
    }
}
