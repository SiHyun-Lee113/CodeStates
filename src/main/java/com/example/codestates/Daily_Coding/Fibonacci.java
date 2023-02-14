package com.example.codestates.Daily_Coding;

public class Fibonacci {
    public static void main(String[] args) {
        int output = fibonacci(0);
        System.out.println(output); // --> 0

        output = fibonacci(1);
        System.out.println(output); // --> 1

        output = fibonacci(5);
        System.out.println(output); // --> 5

        output = fibonacci(9);
        System.out.println(output); // --> 34
    }

    static int[] store = new int[1000];
    public static int fibonacci(int num) {
        if (store[num] != 0) {

        } else {
            if (num <= 2) {
                store[num] = 1;
            } else {
                store[num] = fibonacci(num-1) + fibonacci(num-2);
            }
        }
        return store[num];
    }
}
