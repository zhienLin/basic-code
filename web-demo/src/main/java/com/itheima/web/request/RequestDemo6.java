package com.itheima.web.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zzy
 * @date 2022-11-19 09:19
 */
@WebServlet("/req66")
public class RequestDemo6 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1");

        //太麻烦了
//      response.setStatus(302);
//      response.setHeader("location","/web-demo/req77");

        //简化方式完成重定向
        //动态获取虚拟目录,万一在tomcat中进行了项目访问路径的配置，那么所有重定向的地方都需要进行修改
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/req77");






    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
