package com.example.codestates.Daily_Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderOfPresentation {
    public static void main(String[] args) {
        long output = orderOfPresentation(5, new int[]{1, 3, 2, 4, 5});
        System.out.println(output); // 3

        output = orderOfPresentation(12, new int[]{8,3,9,10,1,2,12,11,7,6,5,4});
        System.out.println(output); // 6
    }

    public static long orderOfPresentation(int N, int[] K) {

        long answer = 0;

        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < K.length; i++) {
            int num = K[i];
            visited[num] = true;
            int cnt = 0;

            boolean[] candidates = Arrays.copyOfRange(visited, 1, num);

            for (boolean candidate : candidates) {
                if (!candidate)
                    cnt++;
            }

            answer += cnt*factorial(N-i-1);
        }

        return (int)answer;
    }

    public static long factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n-1);
    }

//    public static long orderOfPresentation(int N, int[] K) {
//
//        int order = 0;
//
//        List<Long> list = new ArrayList<>();
//        permutation(list, 0, N, new boolean[N], new int[N]);
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i : K)
//            sb.append(i);
//
//        long target = Long.parseLong(sb.toString());
//
//        long start = 0;
//        long end = list.size();
//
//        while (start <= end) {
//            long mid = (start+end) / 2;
//
//            if (list.get((int) mid) == target)
//                return mid;
//
//            if (list.get((int) mid) < target) {
//                start = mid + 1;
//            } else {
//                end = mid -1;
//            }
//        }
//        return order;
//    }
//
//    public static void permutation(List<Long> list, int depth, int r, boolean[] visited, int[]out) {
//        if (depth == r) {
//            StringBuilder temp = new StringBuilder();
//
//            for (int i : out)
//                temp.append(i);
//
//            list.add(Long.parseLong(temp.toString()));
//            return;
//        }
//
//        for (int i = 1; i <= r; i++) {
//            if (!visited[i-1]) {
//                visited[i-1] = true;
//                out[depth] = i;
//                permutation(list, depth+1, r, visited, out);
//                visited[i-1] = false;
//            }
//        }
//    }
}
