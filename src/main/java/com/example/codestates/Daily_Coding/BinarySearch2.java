package com.example.codestates.Daily_Coding;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BinarySearch2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 8, 10};
        int[] arr2 = new int[]{2, 3, 5, 9};
        int result = getItemFromTwoSortedArrays(arr1, arr2, 6);
        System.out.println(result); // --> 8

        arr1 = new int[]{1, 1, 2, 10};
        arr2 = new int[]{3, 3};
        result = getItemFromTwoSortedArrays(arr1, arr2, 4);
        System.out.println(result); // --> 3
    }

    public static int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        int leftIdx = 0;
        int rightIdx = 0;
        while (k > 0) {
            int cnt = (int)Math.ceil(((double) k) / 2);
            int leftStep = cnt;
            int rightStep = cnt;

            if (leftIdx == arr1.length) {
                rightIdx = rightIdx + k;
                break;
            }

            if (rightIdx == arr2.length) {
                leftIdx = leftIdx + k;
                break;
            }

            if (cnt > arr1.length - leftIdx) leftStep = arr1.length - leftIdx;
            if (cnt > arr2.length - rightIdx) rightStep = arr2.length - rightIdx;

            if (arr1[leftIdx + leftStep - 1] < arr2[rightIdx + rightStep - 1]) {
                leftIdx = leftIdx + leftStep;
                k = k - leftStep;
            } else {
                rightIdx = rightIdx + rightStep;
                k = k - rightStep;
            }
        }
        int leftMax = (leftIdx - 1 < arr1.length) ? arr1[leftIdx - 1] : -1;
        int rightMax = (rightIdx - 1 < arr2.length) ? arr2[rightIdx - 1] : -1;

        return Math.max(leftMax, rightMax);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return mid;
    }
}
