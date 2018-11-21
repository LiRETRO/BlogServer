package net.meloli.demo.sys.rabbitmq.service;

public interface IProducerService {

    /**
     * 发送消息到队列
     * @param queueName
     * @param message
     */
    void send(String queueName, String message);

    /**
     * 发送延迟消息到队列
     * @param queueName
     * @param message
     * @param time
     */
    void send(String queueName, String message, Long time);
}
