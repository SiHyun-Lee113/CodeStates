package com.example.codestates.Daily_Coding;

public class Tiling {
    public static void main(String[] args) {
        int output = tiling(1);
        System.out.println(output); // --> 2

        output = tiling(4);
        System.out.println(output); // --> 5
    }

    public static int tiling(int num) {
        long[]dp = new long[num+1];

        for (int i = 1; i <= num; i++) {
            if (i <= 3) {
                dp[i] = i;
            } else{
                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000007;
            }
        }

        return (int) dp[num];
    }
}
