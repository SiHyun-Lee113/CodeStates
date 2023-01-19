package com.example.codestates.Daily_Coding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ABCheck {
    public static void main(String[] args) {
        String str = "454793211";

        System.out.println(test(str));
    }

    private static String test(String str) {
        String answer = "";

        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (i == 0) {
                list.add(String.valueOf(num));
            } else {
                if (num % 2 == 1 && (str.charAt(i-1)-'0') % 2 == 1) {
                    list.add("-");
                    list.add(String.valueOf(num));
                } else
                    list.add(String.valueOf(num));
            }
        }

        answer = list.stream().collect(Collectors.joining());

        return answer;
    }
}
