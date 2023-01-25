package com.example.codestates.MathForAlgorithm;

import java.util.*;

public class BoringBlackjack {
    public static void main(String[] args) {
        int output = boringBlackjack(new int[]{2, 7, 9, 11, 17, 23, 29, 31, 35, 39, 43});
        System.out.println(output); // 1

        int output2 = boringBlackjack(new int[]{2, 3, 4, 8, 13});
        System.out.println(output2); // 3
    }

    public static int boringBlackjack(int[] cards) {

        List<Integer> set =new ArrayList<>();
        combination(set, 0, cards, new int[3], new boolean[cards.length], 0);

        int count = 0;
        for (Integer integer : set) {
            if (isPrime(integer))
                count++;
        }

        return count;
    }

    public static boolean isPrime (int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    public static void combination(List<Integer> list, int depth, int[] cards,
                                   int[] output, boolean[] used, int start) {
        if (depth == 3) {
            int sum = 0;
            for (int i : output) {
                sum += i;
            }
            list.add(sum);
            return;
        }

        for (int i = start; i < cards.length; i++) {
            if (!used[i]) {
                output[depth] = cards[i];
                used[i] = true;
                combination(list, depth+1, cards, output, used, i+1);
                used[i] = false;
            }
        }
    }
}
