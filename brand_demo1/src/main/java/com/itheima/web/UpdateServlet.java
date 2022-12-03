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
 * @date 2022-11-22 19:57
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

    private BrandService service = new BrandService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        Integer id = Integer.parseInt(request.getParameter("id"));
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        Integer ordered = Integer.parseInt(request.getParameter("ordered"));
        String description = request.getParameter("description");
        Integer status = Integer.parseInt(request.getParameter("status"));
        Brand brand = new Brand(id,brandName,companyName,ordered,description,status);

        service.update(brand);

        request.getRequestDispatcher("/selectAllServlet").forward(request,response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
