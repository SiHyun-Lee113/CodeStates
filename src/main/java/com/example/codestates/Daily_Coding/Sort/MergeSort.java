package com.example.codestates.Daily_Coding.Sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] output = mergeSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }

    private static int[] sorted;
    public static int[] mergeSort(int[] arr) {

        sorted = new int[arr.length];
        merge_sort(arr, 0, arr.length - 1);

        return sorted;
    }

    private static void merge_sort(int[] a, int left, int right) {
        for(int size = 1; size <= right; size += size) {
            for(int l = 0; l <= right - size; l += (2 * size)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (2 * size) - 1, right);
                merge(a, low, mid, high);		// 병합작업
            }
        }
    }
    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;		// 왼쪽 부분리스트 시작점
        int r = mid + 1;	// 오른쪽 부분리스트의 시작점
        int idx = left;		// 채워넣을 배열의 인덱스


        while(l <= mid && r <= right) {
            if(a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        if(l > mid) {
            while(r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        else {
            while(l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }
        for(int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }
}
