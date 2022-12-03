package itheima;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zzy
 * @date 2022-11-08 21:44
 */
public class MyBatisDemo {
    public static void main(String[] args) throws IOException {

        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3执行sql语句,一行代码就搞定了，不用封装结果集了
        List<Object> objects = sqlSession.selectList("test.selectAll");
        System.out.println(objects);

        //4释放资源
        sqlSession.close();




    }
}
