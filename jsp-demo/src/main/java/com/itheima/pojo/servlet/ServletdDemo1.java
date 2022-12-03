package com.itheima.pojo.servlet;


import com.itheima.pojo.Brand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 这里使用的是jsp+servlet相结合的技术
 * 主要的逻辑代码只在servlet中进行处理，
 * 然后把处理之后的数据转发到相应的jsp文件中，在jsp文件中用ELSE的表达获取
 * @author zzy
 * @date 2022-11-21 20:02
 */

@WebServlet("/demo1")
public class ServletdDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));

        req.setAttribute("brands",brands);
        req.setAttribute("status",1);

        req.getRequestDispatcher("jsp_servlet.jsp").forward(req,resp);





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
