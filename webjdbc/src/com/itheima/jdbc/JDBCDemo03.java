package com.itheima.jdbc;

import com.itheima.domain.Emp;

import java.sql.*;
import java.util.ArrayList;

public class JDBCDemo03 {
    /**
     * 把查询的结果解析,  每一行的 记录封装到一个 java类的对象中,然后把 每个对象添加到 list集合中,最后
     * 在返回 一个list集合, 那么这个list集合中就有了 查询的 所有的 数据了.
     */
    public static void main(String[] args) {
   /*     if(selectAll()!=null){
            for (int i = 0; i < selectAll().size(); i++) {
                System.out.println(selectAll().get(i));
            }
        }*/
        ArrayList<Emp> list=  JDBCDemo03.selectAll();
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    public static ArrayList<Emp> selectAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList <Emp> list = null;
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///xiao", "root", "root");
            //3.定义sql语句
            String sql = "select * from student";
            //4.获取执行sql语句的对象
            stmt = conn.createStatement();
            //5.执行sql语句
            rs = stmt.executeQuery(sql);

            Emp emp = null;

           list = new ArrayList <Emp>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int score = rs.getInt("score");

                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setScore(score);
                list.add(emp);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
        }
    }