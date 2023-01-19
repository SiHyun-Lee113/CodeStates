package com.example.codestates.Algorithm;

public class BoardGame {
    public static void main(String[] args) {
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        Integer output1 = boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        Integer output2 = boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        Integer output3 = boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }

    public static Integer boardGame(int[][] board1, String operation) {
        Integer result = 0;

        int cur_x = 0;
        int cur_y = 0;
        for (int i = 0; i < operation.length(); i++) {
            int next_x = moving(cur_x, cur_y, operation.charAt(i))[0];
            int next_y = moving(cur_x, cur_y, operation.charAt(i))[1];

            if (next_x > board1.length || next_x < 0 || next_y > board1.length || next_y < 0)
                return null;
            else {
                result += board1[next_x][next_y];
                cur_x = next_x;
                cur_y = next_y;
            }
        }

        return result;
    }

    public static int[] moving(int curX, int curY, char operation) {
        int[] next = new int[2];

        switch (operation) {
            case 'R':
                next[0] = curX;
                next[1] = curY + 1;
                break;
            case 'L':
                next[0] = curX;
                next[1] = curY - 1;
                break;
            case 'D':
                next[0] = curX + 1;
                next[1] = curY;
                break;
            case 'U':
                next[0] = curX - 1;
                next[1] = curY;
                break;
        }

        return next;
    }
}
