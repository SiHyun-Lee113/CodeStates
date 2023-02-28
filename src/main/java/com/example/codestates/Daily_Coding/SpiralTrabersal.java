package com.example.codestates.Daily_Coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SpiralTrabersal {
    public static void main(String[] args) {
        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        String output = spiralTraversal(matrix);
        System.out.println(output); // --> "ABCFIHGDE"

        matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        output = spiralTraversal(matrix);
        System.out.println(output); // --> 'Tyrion Lannister'
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static String spiralTraversal(Character[][] matrix) {
        StringBuilder sb = new StringBuilder();

        int N = matrix.length;
        int M = matrix[0].length;

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        sb.append(matrix[0][0]);
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int curX = queue.peek()[0];
            int curY = queue.poll()[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY]) {

                    sb.append(matrix[nextX][nextY]);
                    visited[nextX][nextY] = true;

                    while (true) {
                        nextX += dx[i];
                        nextY += dy[i];
                        if ((nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY])) {
                            sb.append(matrix[nextX][nextY]);
                            visited[nextX][nextY] = true;
                        } else
                            break;
                    }
                    queue.add(new int[]{nextX - dx[i], nextY - dy[i]});
                    break;
                }
            }
        }

        return sb.toString();
    }
//
//    public String spiralTraversal2(Character[][] matrix) {
//        int[] RIGHT = new int[]{0, 1};
//        int[] DOWN = new int[]{1, 0};
//        int[] LEFT = new int[]{0, -1};
//        int[] UP = new int[]{-1, 0};
//        int[][] MOVES = new int[][]{
//                RIGHT, DOWN, LEFT, UP
//        };
//
//        int M = matrix.length;
//        int N = matrix[0].length;
//
//        int cnt = 0;
//        int row = 0, col = -1;
//        int direction = 0;
//        StringBuilder result = new StringBuilder();
//        while (cnt < M * N) {
//            int[] move = MOVES[direction];
//            int rd = move[0], cd = move[1];
//
//            row = row + rd;
//            col = col + cd;
//            while (isValid(row, col, M, N) && matrix[row][col] != null) {
//                result.append(matrix[row][col]);
//                matrix[row][col] = null;
//                row = row + rd;
//                col = col + cd;
//                cnt++;
//            }
//            // row, col 이 행렬의 범위를 벗어났기 때문에,
//            // 진행된 방향의 반대로 한 칸 이동한다.
//            row = row - rd;
//            col = col - cd;
//
//            // 각 방향이 순환되기 때문에 모듈러 연산을 사용한다.
//            direction = (direction + 1) % 4;
//        }
//        return result.toString();
//    }
//
//    public boolean isValid(int row, int col, int M, int N) {
//        return (row >= 0 && row < M && col >= 0 && col < N);
//    }
}
