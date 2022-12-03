package www.itheima.jdbc;

import jdk.jfr.StackTrace;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * Statement对象的作用就是用来执行SQL语句。而针对不同类型的
 * SQL语句使用的方法也不一样。
 * 执行DDL、DML语句
 * 执行DQL语句
 * @author zzy
 * @date 2022-11-02 10:06
 */
public class JDBC_Statement {
    @Test
    public void methodDML() throws SQLException {
        String url="jdbc:mysql:///itcast?&useSSL=false";
        String name="root";
        String password="085529";
        Connection connection = DriverManager.getConnection(url, name, password);


        String sql ="update score set math = 90 where name = 'Tom'";

        Statement statement = connection.createStatement();

        long rowCount = statement.executeLargeUpdate(sql);

        if(rowCount > 0)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");

        statement.close();
        connection.close();
    }


    @Test
    public void methodDDL() throws SQLException {
        String url="jdbc:mysql:///itcast?&useSSL=false";
        String name="root";
        String password="085529";
        Connection connection = DriverManager.getConnection(url, name, password);

        String sql ="drop DATABASE TryJava";

        Statement statement = connection.createStatement();

        long rowCount = statement.executeLargeUpdate(sql);
        System.out.println(rowCount);

        statement.close();
        connection.close();
    }


    @Test
    public void methodDQL() throws SQLException {
        ArrayList<Score> list = new ArrayList<>();
        String url="jdbc:mysql:///itcast?useSSL=false";
        String name="root";
        String password="085529";
        Connection connection = DriverManager.getConnection(url, name, password);

        String sql ="select * from score";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name_score = resultSet.getString(2);
            int math = resultSet.getInt(3);
            int english = resultSet.getInt(4);
            int chinese = resultSet.getInt(5);
            Score s = new Score(id,name_score,math,english,chinese);
            list.add(s);
        }


        for (Score score : list) {
            System.out.println(score.getId()+" "+score.getName()+" "+score.getMath()+" "+
                    score.getEnglish()+" "+ score.getChinese());
        }

    }
}


class Score{
    private int id;
    private String name;
    private int math;
    private int english;
    private int chinese;

    public Score() {
    }

    public Score(int id, String name, int math, int english, int chinese) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
        this.chinese = chinese;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }
}
