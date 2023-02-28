package com.example.codestates.Daily_Coding;

import java.util.*;
import java.util.stream.Stream;

public class PrimePassword {
    public static void main(String[] args) {
        int output = primePassword(1033, 1033);
        System.out.println(output); // --> 0

        output = primePassword(3733, 8779);
        System.out.println(output); // --> 3 (3733 -> 3739 -> 3779 -> 8779)
    }
    public static int primePassword(int curPwd, int newPwd) {
        if (curPwd == newPwd) return 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[10000];
        isVisited[curPwd] = true;

        queue.add(new int[] {0, curPwd});
        while (!queue.isEmpty()) {
            int step = queue.peek()[0];
            int cur = queue.poll()[1];

            for (int i = 0; i < 4; i++) {
                int[] numbers = splitNumber(cur);
                for (int j = 0; j < 10; j++) {
                    if (numbers[i] != j) {
                        numbers[i] = j;
                        int next = joinDigits(numbers);
                        if (next == newPwd) return step + 1;
                        if (next > 999 && next < 10000 && !isVisited[next] && isPrime(next)) {
                            isVisited[next] = true;
                            queue.add(new int[]{step + 1, next});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isPrime(int num) {
        if(num % 2 == 0) return false;
        int sqrt = (int)(Math.sqrt(num));
        for(int divider = 3; divider <= sqrt; divider += 2) {
            if(num % divider == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] splitNumber(int num) {
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static int joinDigits(int[] arr) {
        String[] tempArr = new String[arr.length];

        for(int i = 0; i < arr.length; i++) {
            tempArr[i] = String.valueOf(arr[i]);
        }

        return Integer.parseInt(String.join("", tempArr));
    }
}