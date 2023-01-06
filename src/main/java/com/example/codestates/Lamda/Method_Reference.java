package com.example.codestates.Lamda;

import java.util.function.IntBinaryOperator;

public class Method_Reference {

    public static void main(String[] args) {
        IntBinaryOperator operator;

        operator = Calculate :: staticMethod;
        System.out.println("정적 메서드 = " + operator.applyAsInt(2, 3));

        Calculate calculate = new Calculate();
        operator = calculate :: instanceMethod;
        System.out.println("인스턴스 메서드 : " + operator.applyAsInt(2, 3));
    }


    static class Calculate {
        public static int staticMethod(int a, int b) {
            return a + b;
        }

        public int instanceMethod(int a, int b) {
            return a * b;
        }
    }
}
