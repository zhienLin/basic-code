package www.itheima.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author zzy
 * @date 2022-11-02 16:29
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\dell\\IdeaProjects\\JDBC\\src\\druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5. 获取数据库连接 Connection
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

    /*
    完成商品品牌数据的增删改查操作
        查询：查询所有数据
        添加：添加品牌
        修改：根据id修改
        删除：根据id删除
     */
    @Test
    public void exer (){

    }



}
