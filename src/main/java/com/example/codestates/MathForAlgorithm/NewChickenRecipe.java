package com.example.codestates.MathForAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewChickenRecipe {
    public static void main(String[] args) {
        ArrayList<Integer[]> output1 = newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);

        for (Integer[] integers : output1) {
            System.out.println(Arrays.toString(integers));
        }

//        ArrayList<Integer[]> output2 = newChickenRecipe(new int[]{10000, 10, 1}, 3);
//        System.out.println(output2); // []
//
        ArrayList<Integer[]> output3 = newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000}, 4);
        for (Integer[] integers : output3) {
            System.out.println(Arrays.toString(integers));
        }
    }

    public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:
        ArrayList<Integer[]> result = new ArrayList<>();
        //재료 선정
        int[] stuff = stuffSelection(stuffArr).stream().sorted().mapToInt(i -> i).toArray();

        if (stuff.length < choiceNum)
            return result;
        // dfs
        dfs(result, 0, choiceNum, new boolean[stuff.length], new int[choiceNum], stuff);
        return result;
    }
    public static void dfs (ArrayList<Integer[]> list, int depth, int choiceNum,
                            boolean[] used, int[] output, int[] stuff) {
        if (depth == choiceNum) {
            Integer[] temp = new Integer[output.length];
            for (int i = 0; i < output.length; i++) {
                temp[i] = output[i];
            }
            list.add(temp);
            return;
        }
        for (int i = 0; i < stuff.length; i++) {
            if (!used[i]) {
                used[i] = true;
                output[depth] = stuff[i];
                dfs(list, depth+1, choiceNum, used, output, stuff);
                used[i] = false;
            }
        }
    }

    public static List<Integer> stuffSelection (int[] stuffArr) {
        List<Integer> list = new ArrayList<>();

        String temp = "";

        for (int i = 0; i < stuffArr.length; i++) {
            if (stuffArr[i] < 1000) {
                list.add(stuffArr[i]);
                continue;
            }

            temp = stuffArr[i] + "";
            int count = 0;

            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '0') {
                    count++;
                    if (count > 2)
                        break;
                }
                if (j == temp.length()-1)
                    list.add(Integer.parseInt(temp));
            }
        }

        return list;
    }

}
