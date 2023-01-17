package com.example.codestates.Recursion;

import java.util.Arrays;

public class Coplet {

    public static void main(String[] args) {
        System.out.println(sumTo(5));
        System.out.println(isOdd(-17));
        System.out.println(fibonacci(9));
        System.out.println(arrSum(new int[]{1, 2, 3, 4}));
        System.out.println(arrProduct(new int[]{1, 2, 3, 4}));
        System.out.println(arrLength(new int[]{1, 2, 3, 4, 5}));
        System.out.println(Arrays.toString(drop(6, new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(take(3, new int[]{1, 2, 3, 4, 5})));
        System.out.println(and(new boolean[]{true, true, true}));
        System.out.println(or(new boolean[]{true, false, true}));
        System.out.println(Arrays.toString(reverseArr(new int[]{1, 2, 3, 4, 5})));

    }
    static public int[] reverseArr(int[] arr){
        // TODO:
        if(arr.length == 0) { //입력된 배열이 빈 배열인 경우
            return new int[]{}; //빈 배열을 반환합니다.
        }
        int[] head = Arrays.copyOfRange(arr, arr.length - 1, arr.length);

        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length - 1));

        int[] dest = new int[head.length + tail.length];

        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);

        return dest;
    }
    static public boolean or(boolean[] arr){
        // TODO:
        if (arr.length == 0)
            return false;
        if (arr.length == 1)
            return arr[0];

        return arr[0] || or(Arrays.copyOfRange(arr, 1, arr.length));
    }
    static public boolean and(boolean[] arr){
        // TODO:
        if (arr.length == 1)
            return arr[0];

        return arr[0] && and(Arrays.copyOfRange(arr, 1, arr.length));
    }
    static public int[] take(int num, int[] arr){
        // TODO:
        if (num >= arr.length)
            return arr;

        if (num == 0 || arr.length == 0)
            return new int[]{};

        return take(num, Arrays.copyOfRange(arr, 0, arr.length-1));
    }
    static public int[] drop(int num, int[] arr){
        // TODO:
        num = Math.min(num, arr.length);
        if (num == 0)
            return arr;
        return drop(num-1, Arrays.copyOfRange(arr, 1, arr.length));
    }
    static public int arrLength(int[] arr){
        //TODO..
        if (arr.length == 0)
            return 0;
        int[] arrsum = Arrays.copyOfRange(arr, 0, arr.length-1);

        return 1 + arrLength(arrsum);
    }
    static public int arrSum(int[] arr){
        //TODO..
        if (arr.length == 0)
            return 0;
        int[] arrsum = Arrays.copyOfRange(arr, 0, arr.length-1);

        return arr[arr.length-1] + arrSum(arrsum);
    }
    static public int arrProduct(int[] arr){
        //TODO..
        if (arr.length == 0)
            return 1;
        int[] arrsum = Arrays.copyOfRange(arr, 0, arr.length-1);

        return arr[arr.length-1] * arrProduct(arrsum);
    }


    static int count = 0;
    static public int fibonacci(int num){
        count++;
        //TODO..
        if (num == 0)
            return 0;
        if (num ==  1 || num == 2)
            return 1;
        return fibonacci(num-1) + fibonacci(num-2);
    }
    static public boolean isOdd(int num) {
        num = Math.abs(num - 2);

        if (num < 2)
            return num == 1;
        return isOdd(num);
    }

    static public int sumTo(int num){
        if (num == 1)
            return 1;

        return num + sumTo(num-1);
    }
}
