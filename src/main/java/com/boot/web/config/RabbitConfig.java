package com.boot.web.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: LiuHeYong
 * @create: 2019-06-05
 * @description: 创建RabbitMQ的配置类 RabbitConfig ，⽤来配置队列、交换器、路由等⾼级信息
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue rabbitQueue() {
        return new Queue("RabbitMQQueueDestination");
    }

}
