package net.meloli.demo.sys.controller;

import net.meloli.demo.sys.base.BaseController;
import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import net.meloli.demo.sys.rabbitmq.service.IProducerService;
import net.meloli.demo.sys.service.inf.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/blog")
public class BlogController extends BaseController {

    @Autowired
    IBlogService iBlogService;

    @Autowired
    IProducerService iProducerService;

    @RequestMapping(value = "sendMsgTest", method = RequestMethod.GET)
    public void sendMsgTest() {
        // 循环发送消息，测试接收者是否可以接收到
        for(int i = 0, len = 10; i < len; ++i ) {
            iProducerService.send(RabbitMQConfig.QUEUE, "测试RabbitMQ消息，这是第" + (i + 1) + "条");
        }
    }

    @RequestMapping(value = "getBlogList", method = RequestMethod.GET)
    public Object getBlogList() {
        return iBlogService.getBlogList();
    }
}
