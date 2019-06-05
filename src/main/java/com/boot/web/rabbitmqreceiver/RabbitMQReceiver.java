package com.boot.web.rabbitmqreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: LiuHeYong
 * @create: 2019-06-05
 * @description: RabbitMQReceiver
 **/
@Component
@RabbitListener(queues = "RabbitMQQueueDestination")
public class RabbitMQReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQReceiver.class);

    @RabbitHandler
    public void receive(String message) {
        logger.info("=======RabbitMQ接收消息:  " + message);
    }
}
