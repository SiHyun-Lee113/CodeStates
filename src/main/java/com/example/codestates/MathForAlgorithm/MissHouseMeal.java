package com.example.codestates.MathForAlgorithm;

import java.util.*;
import java.util.stream.Collectors;

public class MissHouseMeal {
    public static void main(String[] args) {
        ArrayList<String[]> output = missHouseMeal(new String[]{"pasta", "oysterSoup", "beefRibs", "tteokbokki"});
//        ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});

        for (String[] strings : output) {
            System.out.println(Arrays.toString(strings));
        }
    }

    public static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        ArrayList<String[]> answer = new ArrayList<>();
        //정렬
        Arrays.sort(sideDishes);
        //멱집합 = 만들 수 있는 모든 부분집합
        //먹은걸 표시할 배열
        boolean[] ate = new boolean[sideDishes.length];
        for (int i = 0; i < sideDishes.length; i++) {
            choiceSideDishes(answer, sideDishes, new boolean[sideDishes.length], 0, new String[0], 0, i+1);
        }

        answer.sort(((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2))));
        answer.add(0, new String[]{});

        return answer;
    }

    private static void choiceSideDishes(ArrayList<String[]> list, String[] sideDishes,
                                         boolean[] ate, int depth, String[] eatList, int start, int end) {
        if (depth == end) {
            list.add(eatList);
            return;
        }
        for (int i = start; i < sideDishes.length; i++) {
            if (!ate[i]) {
                String[] add = new String[eatList.length+1];
                System.arraycopy(eatList, 0, add, 0, eatList.length);
                add[depth] = sideDishes[i];
                ate[i] = true;
                choiceSideDishes(list, sideDishes, ate, depth+1, add, i+1, end);
                ate[i] = false;
            }
        }
    }
}
