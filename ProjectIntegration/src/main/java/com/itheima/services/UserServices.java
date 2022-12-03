package com.itheima.services;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.PrintWriter;

/**
 * @author zzy
 * @date 2022-11-23 10:52
 */
public class UserServices {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String name, String passsword) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.login(name,passsword);
        sqlSession.close();
        return user;
    }

    public User signUp(String name) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User result = mapper.verify(name);
        sqlSession.close();
        return result;
    }

    public void insert(String name, String password) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insert(name,password);
        sqlSession.commit();
        sqlSession.close();
    }
}
