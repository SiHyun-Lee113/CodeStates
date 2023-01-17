package com.example.codestates.Daily_Coding;

import java.util.StringTokenizer;

public class firstCharacter {
    public static void main(String[] args) {
        String str = "hello world";
        StringTokenizer stk = new StringTokenizer(str, " ");

        String result = "";
        while(stk.hasMoreTokens()) {
            result += stk.nextToken().charAt(0);
        }

        System.out.println(result);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result);

        String s = stringBuilder.reverse().toString();


    }
}
