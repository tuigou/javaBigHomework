package com.iweb.util;


import com.iweb.view.FunctionMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Invest {
    public static int id;
    //    JDBC的第一步 初始化驱动
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
        ) { System.out.println("请输入充值金额：");
            Scanner in=new Scanner(System.in);
            int amount=in.nextInt();
            if(amount<=2000) {
                String sql = "update user set balance = '"+amount+"' where id = '"+id+"' ";
                s.execute(sql);
                int amount2=2000-amount;
                String sql2 = "update user set bankCardBalance = '"+amount2+"' where id = '"+id+"' ";
                s.execute(sql2);
            }else{
                System.out.println("余额不足！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        FunctionMenu function=new FunctionMenu();
        function.main(args);
    }
}
