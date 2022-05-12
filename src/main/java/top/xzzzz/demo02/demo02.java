package top.xzzzz.demo02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class demo02 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url,username,password);

        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 2000 where id = 2";
        String sql3 = "update account set money = 5000 where id = 3";

        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);

            int count1 = statement.executeUpdate(sql1);
            System.out.println(count1);

            int count2 = statement.executeUpdate(sql2);
            System.out.println(count2);

            int count3 = statement.executeUpdate(sql3);
            System.out.println(count3);

            connection.commit();

        } catch (Exception e) {
            connection.rollback();
        }

    }
}
