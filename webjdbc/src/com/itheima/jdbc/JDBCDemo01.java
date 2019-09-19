package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo01 {

    public static void main(String[] args) {
        //1.导入jar包
        //2.注册驱动
        Connection conn =null;
        Statement stmt =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取数据库连接
         conn = DriverManager.getConnection("jdbc:mysql:///xiao", "root", "root");
            //4.定义sql语句
            String sql = "update  student set score = 520";
            //5.获取执行sql语句的对象
        stmt = conn.createStatement();
            int i = stmt.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
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
        }
    }
}

