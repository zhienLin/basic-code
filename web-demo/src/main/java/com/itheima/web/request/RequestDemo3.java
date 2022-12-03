package com.itheima.web.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author zzy
 * @date 2022-11-19 09:19
 */
@WebServlet("/req333")
public class RequestDemo3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.只适用于post方式的乱码问题：
        //因为post获取参数的方式是字符的输入流的形似，因此我们只需要把输入流的编码方式进行设置就可以
        //一般来讲，用post的方式多，因此这种方法比较常用,
        request.setCharacterEncoding("UTF-8");

        //2.因为get的编码方式在tomcat种已经设定好了，因此我们没有办法更改
        //但是我们可以通过编码-解码的方式来解决乱码的问题，这种方式也适用于post
        // 主要有两种解决方法

        String username = request.getParameter("username");

        //2.1 URL的编解码
        String encode = URLEncoder.encode(username, "ISO-8859-1");
        String URLName = URLDecoder.decode(encode, "UTF-8");

        //2.2 字符串的转换
        String name = new String(username.getBytes("ISO-8859-1"),"utf-8");



    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
