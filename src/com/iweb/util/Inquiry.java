package com.iweb.util;

import com.iweb.view.FunctionMenu;

import java.sql.*;

public class Inquiry {
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
        try(
                Connection c =
                        DriverManager.getConnection(url,username,password);
                Statement s = c.createStatement();
        ){
            String sql = "select * from user where id = '"+id+"' ";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){

            int balance = rs.getInt("balance");
            System.out.printf("余额为%d\n",balance);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        FunctionMenu function=new FunctionMenu();
        function.main(args);


    }
}
