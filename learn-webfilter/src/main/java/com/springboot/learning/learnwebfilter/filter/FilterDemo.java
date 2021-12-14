package com.springboot.learning.learnwebfilter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: zjhan
 * @Date: 2021/4/22 16:45
 * @Description:
 **/
@WebFilter(urlPatterns="/web_filter/demo1/*")
public class FilterDemo implements Filter {
    Logger log = LoggerFactory.getLogger(FilterDemo.class);

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info(servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("done");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
