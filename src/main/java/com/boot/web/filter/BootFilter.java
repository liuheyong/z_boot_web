package com.boot.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: LiuHeYong
 * @create: 2019-05-28
 * @description:
 **/
public class BootFilter implements Filter {

    public static final Logger logger = LoggerFactory.getLogger(BootFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("==========Filter开始init==========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("==========进入到filter==========");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("==========Filter开始destroy==========");
    }
}
