package top.xzzzz.demo06;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class demo06 {
    @Test
    public void testResultSet2() throws Exception {
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";


        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from account";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        List<Account> list = new ArrayList<Account>();

        while (resultSet.next()){
            Account account = new Account();

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double money = resultSet.getDouble("money");

            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            list.add(account);
        }
        System.out.println(list);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
