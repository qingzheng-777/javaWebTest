package top.xzzzz.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "root";


        Connection connection = DriverManager.getConnection(url,username,password);

        String sql = "update account set money = 2000 where id = 1";

        Statement statement = connection.createStatement();

        int count = statement.executeUpdate(sql);

        System.out.println(count);

        statement.close();

        connection.close();

    }
}
