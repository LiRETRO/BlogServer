package net.meloli.demo.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.meloli.demo.sys.base.BaseController;
import net.meloli.demo.sys.entity.Blog;
import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import net.meloli.demo.sys.rabbitmq.service.IProducerService;
import net.meloli.demo.sys.service.inf.IBlogService;
import net.meloli.demo.sys.util.MvcDataDto;
import net.meloli.demo.sys.util.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "博客Controller")
@RestController
@RequestMapping("/api/blog")
public class BlogController extends BaseController {

    @Autowired
    IBlogService iBlogService;

    @ApiOperation(value = "获取博客List", notes = "获取博客List")
    @PostMapping(value = "/getBlogList", consumes = "application/json")
    public Object getBlogList(@RequestBody MvcDataDto param) {
        return iBlogService.getBlogList(param);
    }

    @ApiOperation(value = "发布博客", notes = "发布博客")
    @PutMapping(value = "/addBlog")
    public Object addBlog(Blog blog) {
        return iBlogService.addBlog(blog);
    }

    @ApiOperation(value = "获取博客单条详情", notes = "通过ID获取博客详情")
    @GetMapping(value = "/getBlogDetail/{blogId}")
    public Object getBlogDetail(@PathVariable String blogId) {
        return iBlogService.getBlogDetail(blogId);
    }

    @ApiOperation(value = "获取上/下一条博客", notes = "通过当前博客Id获取上/下一条博客")
    @GetMapping(value = "/getBlogPrevAndNext/{blogId}")
    public Object getBlogPrevAndNext(@PathVariable String blogId) {
        return iBlogService.getBlogPrevAndNext(blogId);
    }

    @ApiOperation(value = "删除博客", notes = "删除博客")
    @DeleteMapping(value = "/deleteBlog/{blogId}")
    public Object deleteBlog(@PathVariable String blogId) {
        return iBlogService.deleteBlog(blogId);
    }
}
