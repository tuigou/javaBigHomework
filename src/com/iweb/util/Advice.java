package com.iweb.util;

import com.iweb.view.FunctionMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Advice {
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
            System.out.println("请输入你的建议：");
            Scanner in=new Scanner(System.in);
            String advice=in.nextLine();
            String sql = "update user set advice = '"+advice+"' where id = '"+id+"' ";
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        FunctionMenu function=new FunctionMenu();
        function.main(args);
    }
}
