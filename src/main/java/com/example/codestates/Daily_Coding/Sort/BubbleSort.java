package com.example.codestates.Daily_Coding.Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] output = bubbleSort(new int[]{5, 4, 2, 1, 3});
        System.out.println(Arrays.toString(output));

    }

    public static int[] bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            int count = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    count++;
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
            if (count == 0)
                break;
        }
        return arr;
    }
}