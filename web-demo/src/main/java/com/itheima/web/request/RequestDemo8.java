package com.itheima.web.request;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author zzy
 * @date 2022-11-19 09:19
 */
@WebServlet("/req88")
public class RequestDemo8 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletOutputStream outputStream = response.getOutputStream();

        FileInputStream fis = new FileInputStream("F:\\JAVA\\basic_code\\web-demo\\src\\main\\java\\com\\itheima\\web\\imags\\4.jpg");


//        byte [] buffer = new byte[1024];
//        int len = 0;
//        while((len = fis.read(buffer))!=-1){
//            outputStream.write(buffer,0,len);
//  }


        //代码进行简化
        IOUtils.copy(fis, outputStream);
        fis.close();


    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
