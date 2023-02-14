package com.example.codestates.Daily_Coding;

public class SuperIncreasing {
    public static void main(String[] args) {
        boolean output = superIncreasing(new int[]{1, 3, 6, 13, 54});
        System.out.println(output); // --> true

        output = superIncreasing(new int[]{612, 1226});
        System.out.println(output); // -
    }

    public static boolean superIncreasing(int[] arr) {

        int sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (sum < arr[i]) {
                sum += arr[i];
            } else
                return false;
        }

        return true;
    }
}
