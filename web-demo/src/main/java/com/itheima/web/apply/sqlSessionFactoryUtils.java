package com.itheima.web.apply;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zzy
 * @date 2022-11-19 22:29
 */
public class sqlSessionFactoryUtils {
    static private SqlSessionFactory sqlSessionFactory;


    static {
    String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static  SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }


}
