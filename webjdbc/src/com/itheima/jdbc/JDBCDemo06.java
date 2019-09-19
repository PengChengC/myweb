package com.itheima.jdbc;

import com.itheima.jdbc.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDemo06 {
    //登录
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();

        boolean flag = login(username, password);
        if (flag){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    private static boolean login(String username,String password) {
            if(username == null||password==null){
                return false;
            }
        PreparedStatement pstmt = null;
        try {
            Connection conn = JDBCUtils.getConnction();
            String sql = "select * from user where username = ? and password = ?";

            pstmt = conn.prepareStatement(sql);
            //给预编译的sql语句占位符赋值,第一个参数表示是第几个占位符,第二个参数代表给占位符赋值
            pstmt.setString(1,username );
            pstmt.setString(2,password );
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
