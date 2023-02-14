package com.example.codestates.Daily_Coding;

import java.util.regex.Pattern;

public class NumberSearch {
    public static void main(String[] args) {
        int output = numberSearch("8ab");
        System.out.println(output); // --> 1

        output = numberSearch("Hello6 9World 2,");
        System.out.println(output); // --> 2

        output = numberSearch("Hello6 9World 2, Nic8e D7ay!");
        System.out.println(output); // --> 2
    }
    public static int numberSearch(String str) {
        // TODO:
        str = str.replaceAll(" ", "");
        int length = str.length();

        int sum = 0;

        String[] split = str.split("");
        String pattern = "^[0-9]*$";
        for (String s : split) {
            if (Pattern.matches(pattern, s)) {
                sum += Integer.parseInt(s);
                length -= 1;
            }
        }

        return (int)Math.ceil((double) sum / (double) length);
    }
}
