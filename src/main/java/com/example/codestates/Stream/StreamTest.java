package com.example.codestates.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(5, 6, 7, 8);

        List<Integer> collect = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        List<Integer> collect2 = list1.stream().map(n -> n * 2).collect(Collectors.toList());

        System.out.println("collect2 = " + collect2);


        int[] temperature = {25, 29, 30, 31, 26, 30, 33};

        long count = Arrays.stream(temperature).filter(o -> o >= 30).count();
        System.out.println(count);

        List<String> male = Arrays.asList("김코딩", "최자바", "김코츠");
        List<String> female = Arrays.asList("박해커", "김유클", "김코딩");
        List<String> output;

        char lastName = '김';
        List<String> collect1 = Stream.concat(male.stream(), female.stream())
                .filter(name -> name.startsWith("김"))
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

    }
}