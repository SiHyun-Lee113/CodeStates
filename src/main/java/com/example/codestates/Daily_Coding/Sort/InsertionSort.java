package com.example.codestates.Daily_Coding.Sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] output = insertionSort(new int[]{3, 21, 1});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }

    public static int[] insertionSort(int[] arr) {
        // TODO:

        int key = 0;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];

            for (int j = i-1; j >= 0 && arr[j] > key; j--) {
                swap(arr, j+1, j);
            }
        }

        return arr;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
