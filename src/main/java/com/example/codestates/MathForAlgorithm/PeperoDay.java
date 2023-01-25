package com.example.codestates.MathForAlgorithm;

import java.nio.file.NotLinkException;
import java.util.ArrayList;
import java.util.Arrays;

public class PeperoDay {
    public static void main(String[] args) {
        int M = 4;
        int N = 8;
        ArrayList<Integer[]> output = divideChocolateStick(M, N);

        for (Integer[] integers : output) {
            System.out.println(Arrays.toString(integers));
        }
    }
    public static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // TODO:

        int gcd = getGCD(M, N);

        ArrayList<Integer[]> answer = new ArrayList<>();


        for (int i = 1; i <= gcd; i++) {
            Integer[] result;
            if (M % i == 0 && N % i == 0){
                result = new Integer[]{i, M / i, N / i};
                answer.add(result);
            }
        }

        return answer;
    }

    public static int getGCD(int M, int N) {
        int r = M % N;

        if (r == 0)
            return N;
        else
            return getGCD(N, r);
    }
}
