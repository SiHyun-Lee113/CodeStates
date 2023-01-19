package com.example.codestates.Tree_Graph;

import java.util.Arrays;

public class DFS_barcode {
    public  void main(String[] args) {
//        String output = barcode(3);
//        System.out.println(output); // "121"
//        String output = barcode(7);
//        System.out.println(output); // "1213121"

        String output = barcode(20);
        System.out.println(output);
    }

     public String[] code = {"1", "2", "3"};
     public String barcode(int len) {
        // TODO:
        return dfs("", len);
    }

     public String dfs (String answer, int len) {
        if (answer.length() == len)
            return answer;

        for (int i = 0; i < 3; i++) {
            String currentStr = answer +  code[i];

            if (check(currentStr)) {
                String temp = dfs(currentStr, len);
                if (temp != null) return temp;
            }
        }
        return null;
    }

     static boolean check(String answer) {

        for (int i = 1; i <= answer.length()/2; i++) {
            String back = answer.substring(answer.length()-i);
            String front = answer.substring(answer.length()-i*2, answer.length()-i);
            if (back.equals(front))
                return false;
        }
        return true;
    }

}
