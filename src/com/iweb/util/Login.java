package com.iweb.util;

import java.sql.*;
import java.util.Scanner;
import com.iweb.service.IdentifyingCode;
import com.iweb.view.ShopMenu;
import com.iweb.view.FunctionMenu;

public class Login {
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
                int id = rs.getInt("id");
                System.out.println("请输入您的密码：");
                String pass=in.nextLine();
                String sql2 = "select * from user where username = '"+name+"' and password ='" +pass+"'";
                ResultSet rs2 = s.executeQuery(sql2);
                if(rs2.next()){
                    System.out.println("请输入您的验证码：");
                    IdentifyingCode code=new IdentifyingCode();
                    String str = code.getRandomSting();
                    System.out.println("验证码为："+str);
                    System.out.println("请输入验证码：");
                    String str2=in.nextLine();
                    if(str2.equals(str)){
                        System.out.println("登陆成功!");
                        FunctionMenu functionMenu=new FunctionMenu();
                        functionMenu.id=id;
                        functionMenu.main(args);
                    }else{
                        System.out.println("验证码错误！");
                        ShopMenu shopMenu=new ShopMenu();
                        shopMenu.main(args);
                    }
                }
                else{
                    System.out.println("密码错误！");
                    ShopMenu shopMenu=new ShopMenu();
                    shopMenu.main(args);
                }
            } else {
                //查无此人
                System.out.println("该用户未注册！");
                ShopMenu shopMenu=new ShopMenu();
                shopMenu.main(args);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        FunctionMenu function=new FunctionMenu();
        function.main(args);
    }
}
