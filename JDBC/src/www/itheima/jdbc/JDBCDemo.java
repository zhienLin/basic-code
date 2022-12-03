package www.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC快速入门
 * @author zzy
 * @date 2022-11-02 09:00
 */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1注册驱动,关键字是Driver,可以自动识别(jdk5以后可以不写)
        Class.forName("com.mysql.jdbc.Driver");

        // 2获取连接：Java代码需要发送SQL给MySQL服务端，就需要先建立连接
        // 主要是通过驱动的管理者建立链接
        String url = "jdbc:mysql://127.0.0.1:3306/itcast?&useSSL=false";
        //后面的这个是为了防止警告的发生。因为ssl的通信会比url更是个MySQL现有的版本
        String name = "root";
        String password = "085529";
        Connection connection = DriverManager.getConnection(url, name, password);

        // 3定义SQL语句
        String sql ="update score set math = 89 where name = 'Tom'";

        // 4获取执行SQL对象
        Statement statement = connection.createStatement();

        // 5执行SQL语句
        long rowCount = statement.executeLargeUpdate(sql);

         // 6处理返回结果
        System.out.println(rowCount);

        // 7释放资源
        statement.close();
        connection.close();
    }


}
