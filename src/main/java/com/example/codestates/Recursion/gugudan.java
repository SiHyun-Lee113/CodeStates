package com.example.codestates.Recursion;

public class gugudan {
    public static void main(String[] args) {
        recursion(3, 1);
        int factorial = Factorial(5);
        System.out.println("factorial = " + factorial);
    }

    static void recursion(int n, int i) {
        if (i == 10)
            return;
        System.out.println(n + " * " + i + " = " + n*i);
        recursion(n, i+1);
    }

    static int Factorial(int n) {
        if (n == 0)
            return 1;

        return n * Factorial(n-1);
    }
}

