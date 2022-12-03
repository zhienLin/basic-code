package com.itheima.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet 方法介绍
 */
@WebServlet(urlPatterns="/demo3",loadOnStartup = 1)
public class ServletDemo3 implements Servlet {
    private ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet hello world~");
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public String getServletInfo() {
        return "";
    }


}
