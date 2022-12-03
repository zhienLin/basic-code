package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zzy
 * @date 2022-11-24 09:41
 */
@WebFilter("/*")
public class loginFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        String[] urls = {"/login.jsp", "/imgs/", "/css/", "/loginServlet", "/register.jsp",
                "/registerServlet", "/checkCodeServlet","01-ajax-demo1.html","ajaxServlet"};

        //2.获取当前访问的资源路径
        String url = req.getRequestURL().toString();

        //3.遍历数组，获取到每一个需要放行的资源路径
        for (String u : urls) {
        //4.判断当前访问的资源路径字符串是否包含要放行的的资源路径字符串
        //比如当前访问的资源路径是 /brand-demo/login.jsp
        //而字符串 /brand-demo/login.jsp 包含了 字符串 /login.jsp ，所以这个字符串就需要放行
            if (url.contains(u)) {
                //找到了，放行
                chain.doFilter(request, response);
                return;
            }
        }


        //1. 判断session中是否有user
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");

        //2. 判断user是否为null
        if (name != null) {
            // 登录过了
            //放行
            chain.doFilter(request, response);
        } else {
            // 没有登陆，存储提示信息，跳转到登录页面
            req.setAttribute("login_msg", "您尚未登陆！");
            req.getRequestDispatcher("/login.jsp").forward(req, response);
        }
    }

        public void init (FilterConfig config) throws ServletException {
        }

        public void destroy () {
        }
    }
