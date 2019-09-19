package com.itheima.jdbc;

import com.itheima.domain.Emp2;
import com.itheima.jdbc.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCDemo05 {
    /**
     *
     * 把查询的结果解析,  每一行的 记录封装到一个 java类的对象中,然后把 每个对象添加到 list集合中,最后
     * 在返回 一个list集合, 那么这个list集合中就有了 查询的 所有的 数据了.
     */
    public static void main(String[] args) {
       ArrayList list =   getSelect();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static ArrayList<Emp2> getSelect() {
        ArrayList<Emp2> list = null;
        Connection conn = null;
        PreparedStatement pstmt=null;
        ResultSet rs =null;
        try {
            conn = JDBCUtils.getConnction();
            String sql = "select * from user";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            Emp2 emp = null;
            list = new ArrayList();
            while (rs.next()){
                //以 Java 编程语言中 int 的形式获取此 ResultSet 对象的当前行中指定列的值。  参数写指定的列名
                //ResultSet结果集相当于是一张表
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String string = rs.getString("1");

                emp = new Emp2();
                //给对象赋值
                emp.setId(id);
                emp.setUsername(username);
                emp.setPassword(password);
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list;
    }
}
