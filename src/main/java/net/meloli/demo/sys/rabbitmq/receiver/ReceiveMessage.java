package net.meloli.demo.sys.rabbitmq.receiver;

import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ消息消费者
 * RabbitListener注解表示当前监听的QUEUE
 */
@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE)
public class ReceiveMessage {

    @RabbitHandler
    public void receiver(String content) {
        System.out.println("接收到了消息" + content);
    }

}
