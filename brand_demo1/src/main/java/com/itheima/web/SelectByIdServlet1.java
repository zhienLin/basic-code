package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.services.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zzy
 * @date 2022-11-22 19:44
 */
@WebServlet("/selectByIdServlet")
public class SelectByIdServlet1 extends HttpServlet {

    BrandService service = new BrandService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        Brand brand = service.selectById(id);


        request.setAttribute("brand",brand);


        request.getRequestDispatcher("/update.jsp").forward(request,response);



    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
