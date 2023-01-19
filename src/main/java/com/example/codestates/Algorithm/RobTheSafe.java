package com.example.codestates.Algorithm;

import java.util.Arrays;

public class RobTheSafe {
    public static void main(String[] args) {
        long output = ocean(50, new int[]{10, 20, 50});
//        System.out.println(output); // 4
//
//        output = ocean(100, new int[]{10, 20, 50});
//        System.out.println(output); // 10

        output = ocean(10, new int[]{1, 2, 5, 10});
        System.out.println(output); // 4
    }
    // 5*6 6*5 5*2+6+7*2

    public static long ocean(int target, int[] type) {
        long answer = 0;

        int[][] dp = new int[type.length+1][target+1];

        dp[0][0] = 1;

        for (int i = 1; i <= type.length; i++) {
            for (int j = 0; j <= target; j++) {
                if ( j < type[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-type[i-1]];
                                        /**
                                         * dp는 현상황을 전 상황과 비교해서 만들어 내는 것이다라고 생각한다.
                                         * dp[2][2]로 예시를 들자면
                                         * 0원 과 2월을 합쳐서 2를 만든 경우 1      dp[2][0]
                                         * -> 이 경우는 아래에서 설명한다.
                                         * 1원 2개를 합쳐서 2를 만든 경우 1        dp[1][2]
                                         * 전에 있는 것에 2를 더해서 만들기 때문에
                                         * 현 위치에서 2만큼 뺀 자리 dp[2][0]의 값을 가지고 오는 것이다.
                                         * */
            }
        }
        answer = dp[type.length][target];
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return answer;
    }
}
