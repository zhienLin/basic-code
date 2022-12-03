package com.itheima.web;


import com.itheima.pojo.User;
import com.itheima.services.UserServices;
import com.itheima.utils.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author zzy
 * @date 2022-11-19 09:19
 */
@WebServlet("/signupServlet")
public class signup extends HttpServlet {

    UserServices us = new UserServices();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        password = new String(password.getBytes("ISO-8859-1"), "UTF-8");

        User user = us.signUp(name);


        HttpSession session = request.getSession();
        String checkCodeSession = (String)session.getAttribute("checkCode");

        boolean result = checkCodeSession.equals(checkCode);


        if (user != null) {
            request.setAttribute("register_msg", "用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            if(result==false){
                request.setAttribute("checkCode_msg", "验证码错误");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }else {
                us.insert(name, password);
                request.setAttribute("register_msg", "注册成功，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
