package com.example.codestates.Daily_Coding.Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 67, 5, 4,32, 1};

        arr = heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static int[] heapSort(int[] arr) {
        PriorityQueue<Integer> pr = new PriorityQueue<>();

        for (int i : arr) {
            pr.add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = pr.poll();
        }

        return arr;
    }
}
