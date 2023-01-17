package com.example.codestates.Stack_Queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class printer {
    public static void main(String[] args) {
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7, 4, 5, 6};
//        int[]documents = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        int output = queuePrinter(bufferSize, capacities, documents);
        System.out.println(output); // 8
    }

    private static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        int answer = 0;

        Queue<Integer> printList = new LinkedList<>();
        Queue<Integer> buffer = new LinkedList<>();
        for (int document : documents) printList.add(document);

        for (int i = 0; i < bufferSize; i++) {
            buffer.add(0);
        }
        int memory = capacities;
        while (!buffer.isEmpty() || !printList.isEmpty()) {
            answer++;
            if (!buffer.isEmpty())
                memory += buffer.poll();

            if (!printList.isEmpty()) {
                int num = printList.peek();
                if (num <= memory) {
                    memory -= printList.poll();
                    while (buffer.size() < bufferSize-1)
                        buffer.add(0);
                    buffer.add(num);
                }
            }

        }
        return answer;
    }

    static public boolean check(Queue<Integer> q) {
        for (Integer integer : q) {
            if (integer > 0)
                return true;
        }
        return false;
    }
}
