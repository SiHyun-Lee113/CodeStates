package com.example.codestates.Daily_Coding;

import java.util.Arrays;
import java.util.StringTokenizer;

public class letterCapitalize {
    public static void main(String[] args) {
        String output1 = letterCapitalize("   ");
        System.out.println(output1); // "Hello World"
        String output2 = letterCapitalize("java  is good");
        System.out.println(output2);
    }
    static public String letterCapitalize(String str) {
        // TODO:
        String answer ="";

        String s = str.replaceAll(" ", "");
        if (s.length() == 0)
            return "";

        for (int i = 0; i< str.length(); i++) {
            if (i == 0)
                answer += (char)(str.charAt(i) - 32);
            else {
                if (str.charAt(i-1) == ' ' && str.charAt(i) != ' ') {
                    if (str.charAt(i) >= 97 && str.charAt(i) <= 122)
                        answer += (char)(str.charAt(i) - 32);
                    else {
                        answer += str.charAt(i);
                    }
                }
                else {
                    answer += str.charAt(i);
                }
            }
        }

        return answer;
    }
}
