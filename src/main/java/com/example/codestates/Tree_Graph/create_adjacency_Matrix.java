package com.example.codestates.Tree_Graph;

import java.util.Arrays;

public class create_adjacency_Matrix {
    public static void main(String[] args) {
        int[][] output1 = createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });

        System.out.println(Arrays.deepToString(output1));
        int[][] output2 = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });

        System.out.println(Arrays.deepToString(output2));
    }
    public static int[][] createMatrix(int[][] edges) {
        // TODO:
        int max = foundMax(edges) + 1;
        int[][] result = new int[max][max];

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][2] > 0) {
                result[edges[i][0]][edges[i][1]] = 1;
                result[edges[i][1]][edges[i][0]] = 1;
            } else {
                result[edges[i][0]][edges[i][1]] = 1;
            }
        }
        return result;
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
