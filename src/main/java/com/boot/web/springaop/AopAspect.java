package com.boot.web.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author: jack
 * @create: 2019-06-02
 * @description: spring aop
 **/
/*定义切面的优先级*/
@Order(3)
@Aspect
@Component
public class AopAspect {

    public static final Logger logger = LoggerFactory.getLogger(AopAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.boot.web.web..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if (null == request) {
            logger.info("=======request为null=======");
        }
        // 记录下请求内容
        logger.info("请求的URL为 : " + request.getRequestURL().toString());
        logger.info("请求的HTTP_METHOD为 : " + request.getMethod());
        logger.info("请求的IP为 : " + request.getRemoteAddr());
        logger.info("请求的CLASS_METHOD为 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求的ARGS为 : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        // 处理完请求，返回内容
        logger.info("请求处理完毕，返回内容 : " + ret);
    }

}
