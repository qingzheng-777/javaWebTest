package top.xzzzz.demo01;


import java.sql.*;

public class demo06 {

    public void testLogin() throws Exception {
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";


        Connection connection = DriverManager.getConnection(url, username, password);

        String name = "qingzheng";
        String pwd = "' or '1' = '1";

        String sql = "select * from  where name = '”+username+“' and password = '"+pwd+"'";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
