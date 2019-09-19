package com.itheima.jdbc;


import com.itheima.jdbc.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDemo04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入yonghuming:");
        String username = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();
        boolean flag = JDBCDemo04.login(username, password);
        if(flag){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    private static boolean login(String username,String password) {
        Connection conn =null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        try {
             conn = JDBCUtils.getConnction();
            String sql = "select * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
        //给sql中的?占位符赋值   pstmt.setString()第一个参数代表第几个占位符 第二个参数是给占位符赋值
            pstmt.setString(1, username);
            pstmt.setString(2, password);
             rs = pstmt.executeQuery();
             //执行完查询语句后判断是否有下一行数据 有就代表找到了数据返回true
             return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,pstmt ,conn );
    }
       return false;
}
}
