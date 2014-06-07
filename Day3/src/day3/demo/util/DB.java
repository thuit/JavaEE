package day3.demo.util;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * Created by Administrator on 14-6-7.
 */
public class DB {

    private static final String URL = "jdbc:mysql:///test";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";


    public static Connection getConnection() {
        try {
            new Driver();
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
