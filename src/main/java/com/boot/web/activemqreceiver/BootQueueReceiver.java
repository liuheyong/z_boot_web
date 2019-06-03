package com.boot.web.activemqreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author: LiuHeYong
 * @create: 2019-05-28
 * @description: bootQueueReceiver
 **/
@Component("bootQueueReceiver")
public class BootQueueReceiver {

    public static final Logger logger = LoggerFactory.getLogger(BootQueueReceiver.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "QueueDestination")
    public void receive() {
        Message message = jmsTemplate.receive();
        if (message instanceof TextMessage) {
            logger.info("从QueueDestination接收到的消息：" + message.toString());
        }
    }

}
