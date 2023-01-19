package com.example.codestates.Algorithm;

public class PartTimeJob {
    public static void main(String[] args) {
        int output1 = partTimeJob(4000);
        System.out.println(output1);


        int output2 = partTimeJob(4972);
        System.out.println(output2);
    }
    static public int[] changes = {500, 100, 50, 10, 5, 1};
    private static int partTimeJob(int k) {
        int coin_count = 0;
        int i = 0;
        while (k > 0) {
            coin_count += k / changes[i];
            k = k % changes[i];
            i++;
        }
        return coin_count;
    }
}
