package com.example.codestates.Daily_Coding;

public class powerOfTwo {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(32));
    }
    static public boolean powerOfTwo(long num) {
        long temp = 1;
        if (num == 1)
            return true;
        if (num % 2 != 0)
            return false;

        while (temp < num)
            temp *= 2;

        return temp == num;
    }
}
