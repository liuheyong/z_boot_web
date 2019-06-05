package com.boot.web.activemqreceiver;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * @author: LiuHeYong
 * @create: 2019-05-28
 * @description:
 **/
public class QueueReceiver {

    public static final Logger logger = LoggerFactory.getLogger(QueueReceiver.class);

    public static void main(String[] args) {
        receive();
    }

    private static void receive() {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://192.168.80.128:61616");
        Connection connection = null;
        Session session = null;
        MessageConsumer mc = null;
        try {
            connection = cf.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("myQueue");
            mc = session.createConsumer(destination);
            connection.start();//如读消息前必须先start否则无法读取消息
            Message message = mc.receive();
            if (message instanceof TextMessage) {
                logger.info(((TextMessage) message).getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }

                if (session != null) {
                    try {
                        session.close();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
                if (mc != null) {
                    try {
                        mc.close();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
