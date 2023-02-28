package com.example.codestates.Daily_Coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RobotPath2 {
    public static void main(String[] args) {
        int[][] room = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1},
        };
        int[] src = new int[]{3, 0};
        int sDir = 3;
        int[] dst = new int[]{2, 2};
        int dDir = 2;
        int output = robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output); // --> 11

        room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0},
        };
        src = new int[]{4, 2};
        sDir = 1;
        dst = new int[]{2, 2};
        dDir = 3;
        output = robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output); // --> 7
    }

    // direction       1  2   3   4
    //                 상 우  하  좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int robotPath2(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
        // TODO:
        int n = room[0].length;
        int m = room.length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        visited[src[0]][src[1]] = true;
        queue.add(new int[]{src[0], src[1], sDir});
        int lastDir = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int curDirection = poll[2];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextDirection = i + 1;
                if ( nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                    if (!visited[nextX][nextY] && room[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        int totalMove = 1 + Math.abs(curDirection - nextDirection) + room[curX][curY];
                        room[nextX][nextY] = totalMove;


                        while (true) {
                            nextX += dx[i];
                            nextY += dy[i];
                            if ((nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) && room[nextX][nextY] == 0) {
                                visited[nextX][nextY] = true;
                                room[nextX][nextY] = totalMove;
                                queue.add(new int[]{nextX, nextY, nextDirection});
                            } else
                                break;
                        }

                        queue.add(new int[]{nextX - dx[i], nextY - dy[i], nextDirection});
                        lastDir = nextDirection;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(room));


        return room[dst[0]][dst[1]] + Math.abs(dDir - lastDir);
    }
}
