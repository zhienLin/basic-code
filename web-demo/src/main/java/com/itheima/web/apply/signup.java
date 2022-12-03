package com.itheima.web.apply;


import com.itheima.web.Mapper.UserMapper;
import com.itheima.web.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author zzy
 * @date 2022-11-19 09:19
 */
@WebServlet("/signupServlet")
public class signup extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("userName");
        String password = request.getParameter("password");
        String strName = new String(name.getBytes(), "UTF-8");
        String strPwd = new String(password.getBytes(), "UTF-8");
        name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        password = new String(password.getBytes("ISO-8859-1"), "UTF-8");

        System.out.println(name);
        System.out.println(password);


        //1加载mybatis的核心配置文件，获取SqlSessionFactory

        //2获取SqlSessionFactory的对象，用它来执行sql
        SqlSessionFactory sqlSessionfactory = sqlSessionFactoryUtils.getSqlSessionFactory();

        //3用Mapper代理的方法
        SqlSession sqlSession = sqlSessionfactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User result = mapper.verify(name);

        //获取字符输出流，并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if(result!=null){
            writer.write( "该用户名已存在");
        }else{
            mapper.insert(name,password);
            sqlSession.commit();
        }
        //4释放资源
        sqlSession.close();

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
