package com.boot.web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.boot.web.defaultcontroller.DefaultController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableCaching
@EnableRedisHttpSession
@SpringBootApplication
@ComponentScan("com.boot.web.*")
@EnableDubboConfiguration
@Order(value = 1)
public class ZBootWebApplication extends DefaultController implements CommandLineRunner {

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
            System.out.println("========随boot启动而执行========");
        } catch (Exception e) {
            logger.error("启动异常", e);
            e.printStackTrace();
        }
    }
}
