package com.example.codestates.Daily_Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveExtremes {
    public static void main(String[] args) {
        String[] output = removeExtremes(new String[]{"a", "b", "c", "def"});
        System.out.println(Arrays.toString(output)); // --> ["a"', "b"]

        output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(Arrays.toString(output)); // --> ["where", "the", "word"]

        int[] arr = new int[]{1, 2, 3, 4};
        int[] reverse = new int[arr.length];
        int start = arr.length-1;
    }

    public static int[] Reverse(int[] arr, int[] reverse, int start) {
        if (start == 0) {
            reverse[reverse.length - 1 - start] = arr[start];
            return reverse;
        }
        reverse[reverse.length - 1 - start] = arr[start];
        return Reverse(arr, reverse, start-1);
    }


    private static String[] removeExtremes(String[] arr) {
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 배열에서 가장 짧은 문자열과 가장 긴 문자열의 길이 추출
        for (String string : arr) {
            if (string.length() > max) {
                max = string.length();
            }
            if (string.length() < min) {
                min = string.length();
            }
        }
        // 한개만 지우기 위한 변수
        int min_count = 0;
        int max_count = 0;

        // 만약 가장 짧은, 긴 길이의 문자열이 여러개일경우 나중에 위치한 문자열을 제거해야한다.
        // 따라서 뒤에서 부터 탐색 후 제거
        for (int i = arr.length-1; i > -1; i--) {
            // 카운트가 둘다 0 초과이면 리스트에 추가만 하면된다.
            if (min_count > 0 && max_count > 0) {
                list.add(arr[i]);
            } else {
                if (arr[i].length() == min && min_count < 1) {
                    min_count++;
                    continue;
                }
                if (arr[i].length() == max && max_count < 1) {
                    max_count++;
                    continue;
                }
                list.add(arr[i]);
            }
        }
        Collections.reverse(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
