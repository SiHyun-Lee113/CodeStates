package com.example.codestates.Daily_Coding;

public class CompressString {
    public static void main(String[] args) {
        String output = compressString("abc");
        System.out.println(output); // --> "abc"

        output = compressString("wwwggoppopppp");
        System.out.println(output); // --> "3wggoppo4p"
        //3wgoppop3p
    }
    public static String compressString(String str) {
        // TODO:
        if(str.length() == 0) return "";
        char before = str.charAt(0);
        int count = 1;
        String result = "";

        str = str + ' ';
        for (int i = 1; i < str.length(); i++) {
            if (before == str.charAt(i)) {
                count++;
            } else {
                if (count >= 3) {
                    result = result + count + before;
                } else {
                    for(int j = 0; j < count; j++) {
                        result = result + before;
                    }
                }
                before = str.charAt(i);
                count = 1;
            }
        }
        return result;
    }
}
