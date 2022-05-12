package top.xzzzz.demo01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class demo04 {

    public void testDDL() throws Exception {

//        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";


        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "drop database db2";

        Statement statement = connection.createStatement();

        int count = statement.executeUpdate(sql);

        System.out.println(count);

        statement.close();

        connection.close();
    }
}
