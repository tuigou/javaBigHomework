package com.iweb.service;

import java.util.Random;

public class IdentifyingCode {
    public static String getRandomSting(){
        String str = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        char cs[]=str.toCharArray();
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(cs[r.nextInt(cs.length)]);
        }

        return sb.toString();
}
}
