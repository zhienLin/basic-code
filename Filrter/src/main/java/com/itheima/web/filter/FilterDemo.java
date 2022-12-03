package com.itheima.web.filter;

/**
 * @author zzy
 * @date 2022-11-24 08:48
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter("/*")
public class FilterDemo implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("1.放行之前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("3.放行之后");

    }

    @Override
    public void destroy() {

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}


