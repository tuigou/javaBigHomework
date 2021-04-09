package com.iweb.util;

import java.sql.*;
import java.util.Scanner;
import com.iweb.view.ShopMenu;

public class Register {
    //JDBC初始化驱动
    static String url="jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
    static String username="root";
    static String password="admin";

    public static void main(String[] args) {
        System.out.println("请输入您的用户名：");
        Scanner in=new Scanner(System.in);
        String name=in.nextLine();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection(url,username,password);
            Statement s = c.createStatement();
        ){
            //在用户名表中查找用户名
            String sql = "select * from user where username = '" + name + "'";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                //查到用户名再来验证密码是否正确
                System.out.println("该用户已存在！");
            } else {
                System.out.println("请输入您的密码：");
                String pass = in.nextLine();
                String sql2="insert into user values(null,?,?,0,2000,null)";
                try (Connection c2 = DriverManager.getConnection(url, username, password);
                     PreparedStatement ps =
                             c2.prepareStatement(sql2);

                ) {
                    ps.setString(1, name);
                    ps.setString(2, pass);

                    ps.execute();
                    System.out.println("恭喜你，注册成功！");
                    ShopMenu shopMenu=new ShopMenu();
                    shopMenu.main(args);

                } catch (SQLException e) {

                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}



