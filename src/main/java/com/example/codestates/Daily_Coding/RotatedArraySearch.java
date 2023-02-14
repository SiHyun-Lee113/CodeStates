package com.example.codestates.Daily_Coding;

public class RotatedArraySearch {
    public static void main(String[] args) {
        int output = rotatedArraySearch(new int[]{4, 5, 6, 7, 8, 0, 1, 2, 3}, 5);
        System.out.println(output); // --> 5

        output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);
        System.out.println(output); // --> -1
    }

    public static int rotatedArraySearch(int[] rotated, int target) {
        // TODO:

        int start = 0;
        int end = rotated.length;
        int mid;


        while (start <= end) {
            mid = (start+end)/2;

            if (rotated[mid] == target)
                return mid;

            if (rotated[start] < rotated[mid]) {
                // 왼쪽 절반이 정렬되어 있는 상태
                if (target < rotated[mid] && rotated[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 오른쪽 절반이 정렬되어 있는 상태
                if (target <= rotated[end] && rotated[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}