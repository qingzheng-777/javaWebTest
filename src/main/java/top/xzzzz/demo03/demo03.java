package top.xzzzz.demo03;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo03 {

    @Test
        public void testDML() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";


        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "update account set money = 3000 where id = 1";

        Statement statement = connection.createStatement();

        int count = statement.executeUpdate(sql);

        if (count>0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        statement.close();

        connection.close();
    }
}