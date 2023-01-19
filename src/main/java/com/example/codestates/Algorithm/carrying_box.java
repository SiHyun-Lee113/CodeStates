package com.example.codestates.Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class carrying_box {
    public static void main(String[] args) {
        int output = movingStuff(new int[]{42, 25, 60, 73, 103, 167}, 187);
        System.out.println(output); // 3

        int output2 = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output2); // 4
    }
    public static int movingStuff(int[] stuff, int limit) {
        // TODO:
        Arrays.sort(stuff);

        int start = 0;
        int last = stuff.length-1;

        int left_stuff = 0;
        int right_stuff = 0;
        int two_package = 0;

        while (start < last) {
            left_stuff = stuff[start];
            right_stuff = stuff[last];

            System.out.println(left_stuff + "  " + right_stuff);

            if (left_stuff+right_stuff <= limit) {
                two_package++;
                start++;
                last--;
            } else {
                last--;
            }
        }

        return stuff.length - two_package;
    }
}
