package www.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Connection（数据库连接对象）作用：
     * 获取执行 SQL 的对象(createStatement,prepareStatement)
     * 管理事务(autoCommit(true/false), commit.rollback)
 * Connection
 * @author zzy
 * @date 2022-11-02 10:06
 */
public class JDBC_Connection {
    public static void main(String[] args) throws SQLException {

        String url="jdbc:mysql:///itcast?&useSSL=false";
        String name="root";
        String password="085529";
        Connection connection = DriverManager.getConnection(url, name, password);


        String sql1 ="update score set math = 90 where name = 'Tom'";
        String sql2 ="update score set math = 90 where name = 'Jack'";

        Statement statement = connection.createStatement();


        try {
            connection.setAutoCommit(false);

            long rowCount1 = statement.executeLargeUpdate(sql1);
            System.out.println(rowCount1);

            int b = 3/0;//错误的产生
            long rowCount2 = statement.executeLargeUpdate(sql2);
            System.out.println(rowCount2);
            connection.commit();
        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }

        statement.close();
        connection.close();
    }

}
