package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.services.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        Integer ordered = Integer.parseInt(request.getParameter("ordered"));
        String description = request.getParameter("description");
        Integer status = Integer.parseInt(request.getParameter("status"));

        Brand b = new Brand(null,brandName,companyName,ordered,description,status);
        service.selectAdd(b);

        //3. 转发到查询所有Servlet,进新数据之前的链接
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}