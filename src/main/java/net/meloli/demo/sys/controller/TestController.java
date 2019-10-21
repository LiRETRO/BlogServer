package net.meloli.demo.sys.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import net.meloli.demo.sys.rabbitmq.service.IProducerService;
import net.meloli.demo.sys.util.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "测试Controller", tags = "TestController")
@RestController("sysTestController")
@RequestMapping("/test")
public class TestController {

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

    @ApiOperation(value = "Redis写入测试", notes = "Redis写入测试中")
    @PutMapping(value = "/redisWriteTest")
    public void redisWriteTest() throws Exception {
        RedisHelper.setStringsValue("name", "李天吉");
    }

    @ApiOperation(value = "Redis读取测试", notes = "Redis读取测试中")
    @GetMapping(value = "/redisReadTest")
    public String redisReadTest() throws Exception {
        String name = RedisHelper.getStringsValue("name");
        return name;
    }

    @ApiOperation(value = "Redis删除测试", notes = "Redis删除测试中")
    @DeleteMapping(value = "/redisDelTest")
    public void redisDelTest() throws Exception {
        RedisHelper.delKey("name");
    }

    @ApiOperation(value = "异常测试", notes = "异常测试中")
    @GetMapping(value = "/exceptionTest")
    public void exceptionTest() throws Exception {
        throw new Exception("异常测试");
    }

    @ApiOperation(value = "断路器测试", notes = "断路器测试中")
    @GetMapping(value = "/hystrixTest")
    public String hystrixTest() throws Exception {
//        throw new Exception("异常是否触发断路");
        Thread.sleep(11000);
        return "成功！";
    }
}
