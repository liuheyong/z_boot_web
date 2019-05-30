package com.boot.web.config;

import com.boot.web.filter.BootFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: LiuHeYong
 * @create: 2019-05-28
 * @description:
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean frb = new FilterRegistrationBean(new BootFilter());
        frb.addUrlPatterns("/*");
        return frb;
    }

}
