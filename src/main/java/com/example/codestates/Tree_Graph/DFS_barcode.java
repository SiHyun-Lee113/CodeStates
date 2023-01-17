package com.example.codestates.Tree_Graph;

import java.util.Arrays;

public class DFS_barcode {
    public static void main(String[] args) {
//        String output = barcode(3);
//        System.out.println(output); // "121"
//        String output = barcode(7);
//        System.out.println(output); // "1213121"

        String output = barcode(20);
        System.out.println(output);

        String str = "1212";
        System.out.println(" = " + check2(str));
    }
    static public boolean[] visited = new boolean[3];
    static public String[] code = new String[]{"1", "2", "3"};
    static public String Answer = "";
    static public String barcode(int len) {
        // TODO:
        dfs(0, len, visited);
        System.out.println(Answer);
        return "";
    }

    static public void dfs (int depth, int len, boolean[] visited) {
        if (depth == len) {
            System.out.println(depth + "asjdlkfjakjsdfkjakls");
            return;
        }
        System.out.println(Answer);
        System.out.println(Arrays.toString(visited));
        System.out.println("-----------------------");

        for(int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                Answer += code[i];
                if (check(Answer)) {
                    visited[i] = true;
                    System.out.println(Arrays.toString(visited) + " " + (i+1) + " "+ Answer);
                    Answer = Answer.substring(0, Answer.length()-1);
                    continue;
                }

                visited = new boolean[3];
                visited[i] = true;
                dfs( depth+1, len, visited);

                break;
            }
        }
    }

    private static boolean check(String answer) {
        if (answer.length() < 4)
            return false;
        for (int i = 1; i <= answer.length()/2; i++) {
            String back = answer.substring(answer.length()-i);
            String front = answer.substring(answer.length()-i*2, answer.length()-i);
            if (back.equals(front))
                return true;
        }
        return false;
    }
    private static boolean check2(String answer) {
        if (answer.length() < 3)
            return false;
        for (int i = 1; i <= answer.length()/2; i++) {
            String back = answer.substring(answer.length()-i);
            String front = answer.substring(answer.length()-i*2, answer.length()-i);
            if (back.equals(front)) {
                System.out.println(front + " " + back);
                return true;
            }
        }
        return false;
    }
}
