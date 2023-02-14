package com.example.codestates.Daily_Coding;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1};

        System.out.println(Arrays.toString(quickSort(arr)));
    }

    public static int[] quickSort(int[] arr) {
        l_pivot_sort(arr, 0, arr.length-1);

        return arr;
    }
    private static void l_pivot_sort(int[] a, int lo, int hi) {
        if(lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        l_pivot_sort(a, lo, pivot - 1);
        l_pivot_sort(a, pivot + 1, hi);
    }

    private static int partition(int[] a, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = a[left];
        while(lo < hi) {
            while(a[hi] > pivot && lo < hi) {
                hi--;
            }

            while(a[lo] <= pivot && lo < hi) {
                lo++;
            }
            swap(a, lo, hi);
        }

        swap(a, left, lo);
        return lo;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}