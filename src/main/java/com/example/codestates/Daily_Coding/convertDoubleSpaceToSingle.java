package com.example.codestates.Daily_Coding;

public class convertDoubleSpaceToSingle {
    public static void main(String[] args) {
        String str = "a  b";

        str = str.replaceAll("  ", " ");

        System.out.println(str);
    }
}
