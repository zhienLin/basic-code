package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author zzy
 * @date 2022-11-16 16:15
 */
@WebServlet("/demo1")
public class Servletdemo1 implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servler!");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
