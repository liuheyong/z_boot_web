package com.boot.web.websecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: z_boot_commons
 * @author: jack
 * @create: 2019-06-01
 * @description: spring security
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // '/'和'home'不需要认证就能访问
                .antMatchers("/", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                //通过 formLogin() 定义当需要⽤户登录时候，转到的登录⻚⾯。
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /**
     * @Param: auth
     * @return: void
     * @Description: configureGlobal(AuthenticationManagerBuilder auth) ⽅法，在内存中创建了⼀个⽤户，该
     * ⽤户的名称为user，密码为password，⽤户⻆⾊为USER
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
    }
}

