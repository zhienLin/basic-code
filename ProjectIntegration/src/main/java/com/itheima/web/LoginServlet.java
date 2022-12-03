package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.services.UserServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author zzy
 * @date 2022-11-23 10:44
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    UserServices us = new UserServices();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取相应的参数并进行空格、乱码的处理
        String name = request.getParameter("username");
        String passsword = request.getParameter("password");
        String remember = request.getParameter("remember");
        name = name.trim();
        passsword = passsword.trim();
        name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        passsword = new String(passsword.getBytes("ISO-8859-1"), "UTF-8");



        //调用应用层的方法进行查询
        User login = us.login(name, passsword);

        if(login!=null){

            if("on".equals(remember)) {
                Cookie cookieName = new Cookie("userName", login.getUsername());
                Cookie cookiePwd = new Cookie("Pwd", login.getPassword());
                cookieName.setMaxAge(60 * 60 * 24 * 7);
                cookiePwd.setMaxAge(60 * 60 * 24 * 7);
                Cookie cookie = new Cookie("username","zs");
                response.addCookie(cookieName);
                response.addCookie(cookiePwd);
                response.addCookie(cookie);
                System.out.println(1);
            }

            //如果不为null建立会话，传递当前用户的名字
            HttpSession session = request.getSession();
            session.setAttribute("name",name);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");

        }else {
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
