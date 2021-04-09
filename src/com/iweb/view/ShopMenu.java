package com.iweb.view;
import com.iweb.util.Login;
import com.iweb.util.Register;

import java.util.Scanner;

public class ShopMenu {
    public static void main(String[] args) {
        System.out.println("-----------------欢迎来到商城-----------------");
        System.out.println("请选择你想进行的服务：");
        System.out.println("1.用户登录");
        System.out.println("2.用户注册");
        System.out.println("0.退出商城");
        Scanner in=new Scanner(System.in);
        int i=in.nextInt();
        switch(i){
            case 1:
                Login login=new Login();
                login.main(args);
                break;
            case 2:
                Register register=new Register();
                register.main(args);
                break;
            case 0:
                break;
        }
    }
}
