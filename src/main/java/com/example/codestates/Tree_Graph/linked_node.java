package com.example.codestates.Tree_Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class linked_node {
    public static void main(String[] args) {
        int result = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {4, 5},
        });
        System.out.println(result); // 3
    }
    static public int connectedVertices(int[][] edges) {
        // TODO:
        int count = 0;

        int max = foundMax(edges) + 1;
        int[][] board = new int[max][max];

        for (int[] edge : edges) {
            board[edge[0]][edge[1]] = 1;
            board[edge[1]][edge[0]] = 1;
        }
        boolean[] visited = new boolean[board.length];

        for (int i = 0; i < board.length; i++) {
            if (!visited[i]) {
                bfs(board, i, visited);
                count++;
            }
        }

        return count;
    }

    public static void bfs (int[][] board, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < visited.length; i++) {
                if (board[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static int foundMax(int[][] edges) {
        int max = -1;

        for (int[] edge : edges) {
            for (int i : edge) {
                max = Math.max(i, max);
            }
        }
        return max;
    }
}
