package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.services.BrandService;
import jdk.swing.interop.SwingInterOpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private  BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 调用BrandService完成查询
        List<Brand> brands = service.selectAll();

        //2. 将集合转换为JSON数据序列化
        String jsonString = JSON.toJSONString(brands);

        //3. 响应数据
        response.setContentType("text/jason;charset=UTF-8");
        response.getWriter().write(jsonString);

/*        //2. 存入request域中
        request.setAttribute("brands",brands);

        //3. 转发到brand.jsp
        request.getRequestDispatcher("/brand.jsp").forward(request,response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}