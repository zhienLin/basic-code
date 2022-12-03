package com.itheima.web.request;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zzy
 * @date 2022-11-19 09:19
 */
@WebServlet("/req77")
public class RequestDemo7 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的数据格式及数据的编码
        //response.setContentType("text/html;charset=utf-8");

        //PrintWriter writer = response.getWriter();
        ServletOutputStream outputStream = response.getOutputStream();

        FileInputStream fis = new FileInputStream("F:\\JAVA\\basic_code\\web-demo\\src\\main\\java\\com\\itheima\\web\\imags\\4.jpg");

        byte [] buffer = new byte[1024];
        int len = 0;
        while((len = fis.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        fis.close();
/*        writer.write("你好呀");
        writer.write("<h1>aaa<h1><br>");
        writer.write("姓名<input>");*/

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
