package com.example.codestates.Daily_Coding;

import java.util.Arrays;

public class IsIsogram {
    public static void main(String[] args) {
        boolean output = isIsogram("aba");
        System.out.println(output); // false

        output = isIsogram("Dermatoglyphics");
        System.out.println(output); // true

        output = isIsogram("moOse");
        System.out.println(output);
    }
    public static boolean isIsogram (String str) {
        boolean[] isUsed = new boolean[26];
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (isUsed[index])
                return false;
            else
                isUsed[index] = true;
        }

        return true;
    }
}
