package com.boot.web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.context.request.RequestContextListener;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: LiuHeYong
 * @create: 2019-05-28
 * @description: ZBootWebApplication
 **/
@EnableScheduling
@EnableAsync
@EnableCaching
@EnableRedisHttpSession
@SpringBootApplication
@ComponentScan("com.boot.web.*")
@EnableDubboConfiguration
@Order(value = 1)
public class ZBootWebApplication implements CommandLineRunner {

    public static final Logger logger = LoggerFactory.getLogger(ZBootWebApplication.class);

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ZBootWebApplication.class);
        //禁止命令行设置环境参数
        springApplication.setAddCommandLineProperties(false);
        springApplication.run(args);
        //BootQueueReceiver receiver = (BootQueueReceiver) context.getBean("bootQueueReceiver");
        //receiver.receive();
    }

    /**
     * @date: 2019/5/28
     * @param: [strings]
     * @return: void
     * @description: 这个方法不需要手动调用，在启动SpringBoot以后这个方法会被自动执行并存在于Spring容器中
     */
    @Override
    public void run(String... strings) {
        try {
            logger.info("============随boot启动而执行============");
        } catch (Exception e) {
            logger.error("启动异常", e);
            e.printStackTrace();
        }
    }

    /**
     * @date: 2019/5/28
     * @description: 在Spring Boot主类中定义⼀个线程池
     */
    @EnableAsync
    @Configuration
    class TaskPoolConfig {
        @Bean("taskExecutor")
        public Executor taskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(10);
            executor.setMaxPoolSize(20);
            executor.setQueueCapacity(200);
            executor.setKeepAliveSeconds(60);
            executor.setThreadNamePrefix("taskExecutor-");
            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            return executor;
        }
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

}
