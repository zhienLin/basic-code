package www.itheima.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 品牌类型的增删改查
 * @author zzy
 * @date 2022-11-02 17:01
 */
public class BrandTest {

    /**
     * 查询所有
     * 1. SQL：select * from tb_brand;
     * 2. 参数：不需要
     * 3. 结果：List<Brand>
     */
    @Test
    public void select() throws Exception {
        ArrayList<Brand> list = new ArrayList<>();
        //1 注册驱动（mysql5.0以后的版本可以省略这一步）
        //2 获取连接池（用数据库连接池）
            //1.导入jar包
            //2.定义配置文件
            //3.加载配置文件
            Properties prop = new Properties();
            prop.load(new FileInputStream("C:\\Users\\dell\\IdeaProjects\\JDBC\\src\\druid.properties"));
            //4. 获取连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            //5. 获取数据库连接 Connection
            Connection connection = dataSource.getConnection();


        //3 确定sql
        String sql ="select * from tb_brand";

        //4 获取执行sql的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //5 设置参数

        //6 执行sql语句
        ResultSet resultSet = preparedStatement.executeQuery();

        //7 放进集合中
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String CompanyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("Ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");
            Brand b = new Brand(id,brandName,CompanyName,ordered,description,status);
            list.add(b);
        }

        //8 关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

        for (Brand brand : list) {
            System.out.println(brand);
        }

    }

    /**
     * 添加
     * 1. insert into tb_brand(brand_name,
     * company_name, ordered, description, status)
     * values(?,?,?,?,?);
     * 2. 参数：需要，除了id之外的所有参数信息
     * 3. 结果：boolean
     */
    @Test
    public void insert() throws Exception {
        //1 注册驱动
        //2 获取链接
            //2.1 导入jar包
            //2.2 定义配置文件
            //2.3 加载配置文件
            Properties prop  = new Properties();
            prop.load(new FileInputStream("C:\\Users\\dell\\IdeaProjects\\JDBC\\src\\druid.properties"));
            //2.4 获取连接池的对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            //2.5 取的链接
            Connection connection = dataSource.getConnection();
       //3 定义sql语句
        String sql = "insert into tb_brand(brand_name,company_name, ordered, " +
                "description, status) values(?,?,?,?,?)";
       //4 数据库执行的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"桃李面包");
        preparedStatement.setString(2,"桃李食品有限公司");
        preparedStatement.setInt(3,200000);
        preparedStatement.setString(4,"软软糯糯甜甜");
        preparedStatement.setInt(5,0);
        //5 取得结果
        long l = preparedStatement.executeUpdate();

        //6 设置参数
        if (l > 0)
            System.out.println(true);
        else
            System.out.println(false);

        //7 释放资源
        preparedStatement.close();
        connection.close();



    }

    @Test
    public void update(){

    }

    @Test
    public void drop(){

    }
}
