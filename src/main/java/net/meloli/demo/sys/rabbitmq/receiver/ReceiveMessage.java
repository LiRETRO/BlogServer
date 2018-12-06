package net.meloli.demo.sys.rabbitmq.receiver;

import com.alibaba.fastjson.JSON;
import net.meloli.demo.sys.dto.VisitDto;
import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import net.meloli.demo.sys.service.inf.IBlogRecordService;
import net.meloli.demo.sys.service.inf.IBlogService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ消息消费者
 * RabbitListener注解表示当前监听的QUEUE
 */
@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE)
public class ReceiveMessage {

    @Autowired
    IBlogRecordService iBlogRecordService;

    @RabbitHandler
    public void receiver(String json) {
        if(!"".equals(json)) {
            VisitDto visitDto = JSON.toJavaObject(JSON.parseObject(json), VisitDto.class);
            iBlogRecordService.saveBlogVisitRecord(visitDto);
        }
    }

}
