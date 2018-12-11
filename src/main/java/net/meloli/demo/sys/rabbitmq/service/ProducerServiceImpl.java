package net.meloli.demo.sys.rabbitmq.service;

import net.meloli.demo.sys.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("producerService")
public class ProducerServiceImpl implements IProducerService, RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 发送消息到队列
     *
     * @param queueName
     * @param message
     */
    @Override
    public void send(String queueName, String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, queueName, message);
    }

    /**
     * 发送延迟消息到队列
     *
     * @param queueName
     * @param message
     * @param time
     */
    @Override
    public void send(String queueName, String message, Long time) {
//        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, queueName, message, time);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause);
        }
    }
}
