import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import top.xzzzz.pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
    @Test
    public void testSelectAll() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\code\\IdeaProjects\\javaWebTest\\test01\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();

        String sql = "select * from tb_brand";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        Brand brand = null;
        List<Brand> brands = new ArrayList<Brand>();

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setDescription(description);
            brand.setOrdered(ordered);
            brand.setStatus(status);

            brands.add(brand);
        }

        System.out.println(brands);

        resultSet.close();
        preparedStatement.close();
        connection.close();


    }


    @Test
    public void testAdd() throws Exception {

        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\code\\IdeaProjects\\javaWebTest\\test01\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();

        String sql = "insert into tb_brand(brand_name, company_name, ordered, description,status) values(?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);

        int count = preparedStatement.executeUpdate();

        System.out.println(count > 0);

        preparedStatement.close();
        connection.close();


    }
    @Test
    public void testUpdate() throws Exception {

        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 100;
        String description = "绕地球三圈";
        int status = 1;
        int id = 4;

        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\code\\IdeaProjects\\javaWebTest\\test01\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();

        String sql = "update tb_brand\n" +
                "     set brand_name = ?,\n" +
                "     company_name= ?,\n" +
                "     ordered  = ?,\n" +
                "    description = ?,\n" +
                "    status = ?\n" +
                " where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);
        preparedStatement.setInt(6,id);

        int count = preparedStatement.executeUpdate();

        System.out.println(count > 0);

        preparedStatement.close();
        connection.close();

    }
    @Test
    public void testDeleteById() throws Exception {

        int id = 4;

        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\code\\IdeaProjects\\javaWebTest\\test01\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();

        String sql = "delete from tb_brand where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        preparedStatement.setInt(1,id);

        int count = preparedStatement.executeUpdate();

        System.out.println(count > 0);

        preparedStatement.close();
        connection.close();

    }

}
