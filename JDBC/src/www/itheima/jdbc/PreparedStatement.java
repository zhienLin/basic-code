package www.itheima.jdbc;

import org.junit.Test;

import java.sql.*;

/**解决java注入的问题
 * @author zzy
 * @date 2022-11-02 15:03
 */
public class PreparedStatement {
    @Test
     public void injectProblem () throws SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
        String name="root";
        String pwd="085529";
        Connection connection = DriverManager.getConnection(url, name, pwd);

        String loginName="zhangsan";
        String password = "' or '1' = '1";
        String sql = "select * from user where username ='"+loginName+"' and password = '"+password+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next())
            System.out.println("修改成功");
        else
            System.out.println("修改失败");

    }

    @Test
    public void preparedStatement () throws SQLException {

        String url="jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useServerPrepStmts=true";
        String name="root";
        String pwd="085529";
        Connection connection = DriverManager.getConnection(url, name, pwd);


        String sql = "select * from user where username = ? and password = ?";


        String loginName="zhangsan";
        String password = "' or '1' = '1";

        java.sql.PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,loginName);
        ps.setString(2,password);

        ResultSet resultSet = null;
        resultSet = ps.executeQuery();

        ps.setString(1,"aaa");
        ps.setString(2,"bbb");
        resultSet = ps.executeQuery();


        if (resultSet.next())
            System.out.println("修改成功");
        else
            System.out.println("修改失败");

    }
}

