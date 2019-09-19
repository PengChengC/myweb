package com.itheima.jdbc;

import com.itheima.jdbc.jdbcutils.JDBCUtils;

import java.sql.*;
import java.util.Properties;

public class JDBCDemo02 {

    public static void main(String[] args) {
        Connection conn =null;
        Statement stmt =null;
        ResultSet rs = null;
        //1.注册驱动
        try {
         //   Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接对象
         //   conn = DriverManager.getConnection("jdbc:mysql:///xiao", "root", "root");

           conn = JDBCUtils.getConnction();
            //3.定义sql语句
            String sql = "select * from student";
            //4.获取执行sql语句的对象
             stmt = conn.createStatement();
            //5.执行sql语句
            rs = stmt.executeQuery(sql);
            Properties p = new Properties();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int score = rs.getInt("score");
                System.out.println(id+"--"+name+"--"+score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
          /*  if(rs!=null){
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
            }*/
          JDBCUtils.close(rs,stmt ,conn );
            }
        }

}
