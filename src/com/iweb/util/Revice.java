package com.iweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Revice {
    public static int id;
    static String url =
            "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
    static String username = "root";
    static String password = "admin";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection(url, username, password);
             Statement s = c.createStatement();
        ) {
            System.out.println("请输入新的用户名：");
            Scanner in=new Scanner(System.in);
            String name=in.nextLine();
            System.out.println("请输入新的密码：");
            String pass=in.nextLine();
                String sql = "update user set username = '"+name+"' where id = '"+id+"' ";
                s.execute(sql);
                String sql2 = "update user set password = '"+pass+"' where id = '"+id+"' ";
                s.execute(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
