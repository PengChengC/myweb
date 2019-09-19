package com.itheima.jdbc.jdbcutils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static{
        Properties ps = new Properties();
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("com/jdbc.properties");
            ps.load(is);
            url = ps.getProperty("url");
            user = ps.getProperty("user");
            password = ps.getProperty("password");
            driver = ps.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获得连接的方法
    public static Connection getConnction() throws SQLException {
            return DriverManager.getConnection(url, user, password);
    }
    //释放资源
    public static void close(ResultSet rs, Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
