package com.iweb.view;

import java.util.Scanner;

import com.iweb.util.Advice;
import com.iweb.util.Inquiry;
import com.iweb.util.Invest;
import com.iweb.util.Revice;

public class FunctionMenu  {
    public static int id;
    public static void main(String[] args) {
        System.out.println("1.账户余额查询");
        System.out.println("2.账户充值");
        System.out.println("3.修改用户信息");
        System.out.println("4.购物功能");
        System.out.println("5.给出建议");
        System.out.println("0.退出系统");
        System.out.println("请选择你需要的服务：");
        Scanner in=new Scanner(System.in);
        int i=in.nextInt();
        switch(i){
            case 1:
                Inquiry inquiry=new Inquiry();
                inquiry.id=id;
                inquiry.main(args);
                break;
            case 2:
                Invest invest=new Invest();
                invest.id=id;
                invest.main(args);
                break;
            case 3:
                Revice revise=new Revice();
                revise.id=id;
                revise.main(args);
                break;
            case 4:
                break;
            case 5:
                Advice advice=new Advice();
                advice.id=id;
                advice.main(args);
                break;
            case 0:
                break;

        }
    }
}
