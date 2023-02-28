package com.example.codestates.Daily_Coding;

public class BinarySearch {
    public static void main(String[] args) {
        int output = binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6}, 2);
        System.out.println(output); // --> 2

        output = binarySearch(new int[]{4, 5, 6, 9}, 100);
        System.out.println(output); // --> -1
    }

    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
