package com.example.codestates.Daily_Coding;

public class IsSubsetOf {
    public static void main(String[] args) {
        int[] base = new int[]{1, 2, 3, 4, 5};

        int[] sample = new int[]{1, 3};
        boolean output = isSubsetOf(base, sample);
        System.out.println(output); // --> true

        sample = new int[]{6, 7};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false

        base = new int[]{10, 99, 123, 7};
        sample = new int[]{11, 100, 99, 123};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false
    }

    public static boolean isSubsetOf(int[] base, int[] sample) {
        int count = 0;

        for (int i : sample) {
            for (int i1 : base) {
                if (i == i1)
                    count++;
            }
        }

        return count==sample.length;
    }
}
