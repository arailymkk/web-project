package kz.epam.webb.dao;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MySqlDataSourceFactory {

    public static MysqlDataSource createMysqlDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        Properties properties = new Properties();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            dataSource.setURL(properties.getProperty("com.mysql.cj.jdbc.Driver"));
            dataSource.setUser(properties.getProperty("root"));
            dataSource.setPassword(properties.getProperty("dastan11"));
        return dataSource;
    }
}
