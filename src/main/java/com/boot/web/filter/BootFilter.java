package com.boot.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: LiuHeYong
 * @create: 2019-05-28
 * @description:
 **/
public class BootFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("======开始init======");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入到filter中");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("======开始destroy======");
    }
}
