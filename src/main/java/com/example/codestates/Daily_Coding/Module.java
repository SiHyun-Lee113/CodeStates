package com.example.codestates.Daily_Coding;

public class Module {
    public static void main(String[] args) {
        Integer output = modulo(25, 4);
        System.out.println(output); // --> 1

        output = modulo(25, 0);
        System.out.println(output);

    }
    public static Integer modulo(int num1, int num2) {
        if (num1 == 0)
            return 0;

        if (num2 == 0)
            return null;

        while (num1 > num2) {
            num1 -= num2;
        }

        return num1;
    }
}
