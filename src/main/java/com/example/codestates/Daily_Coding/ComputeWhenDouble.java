package com.example.codestates.Daily_Coding;

public class ComputeWhenDouble {
    public static void main(String[] args) {
        int result = computeWhenDouble(100);
        System.out.println("result = " + result);
    }
    static public int computeWhenDouble(double interestRate) {
        // TODO:
        int count = 0;
        double total = 100.0;
        double target = total * 2;
        while (total < target) {
            count++;
            total += (total / 100) * interestRate;
            System.out.println(total);
        }
        return count;
    }
}
