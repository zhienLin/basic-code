package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.services.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private  BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /*String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        Integer ordered = Integer.parseInt(request.getParameter("ordered"));
        String description = request.getParameter("description");
        Integer status = Integer.parseInt(request.getParameter("status"));

        Brand b = new Brand(null,brandName,companyName,ordered,description,status);*/

        BufferedReader reader = request.getReader();


        String brandStr = reader.readLine();

        System.out.println(brandStr);

        Brand brand = JSON.parseObject(brandStr, Brand.class);


        service.selectAdd(brand);

       response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}