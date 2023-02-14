package com.example.codestates.Daily_Coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RobotPath {
    public static void main(String[] args) {
        int[][] room = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};
        int output = robotPath(room, src, dst);
        System.out.println(output); // --> 8
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int robotPath(int[][] room, int[] src, int[] dst) {
        boolean[][] visited = new boolean[room.length][room[0].length];

        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                if (room[i][j] == 1)
                    visited[i][j] = true;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(src);
        visited[src[0]][src[1]] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];

                if (nextX >= 0 && nextX < room.length && nextY >= 0 && nextY < room[0].length) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        room[nextX][nextY] += room[poll[0]][poll[1]] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }

                    if (nextX == dst[0] && nextY == dst[1])
                        return room[nextX][nextY];
                }
            }
        }

        return -1;
    }
}
