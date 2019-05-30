package com.boot.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author: LiuHeYong
 * @create: 2019-05-28
 * @description:
 **/
@Component("myMessageListener")
public class MyMessageListener implements MessageListener {

    public static final Logger logger = LoggerFactory.getLogger(MyMessageListener.class);

    @JmsListener(destination = "QueueDestination")
    @Override
    public void onMessage(Message message) {
        logger.info("从QueueDestination接收到的消息：" + message);
    }
}
