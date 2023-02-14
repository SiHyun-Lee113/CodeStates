package com.example.codestates.Daily_Coding;

import java.util.Arrays;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        boolean output = balancedBrackets("");
        System.out.println(output); // --> true

        boolean output2 = balancedBrackets("[({})]");
        System.out.println(output2); // --> true

        boolean output3 = balancedBrackets("[(]{)}");
        System.out.println(output3); // --> false
    }

    public static boolean balancedBrackets(String str) {
        // TODO:
        if(str.length() == 0)
            return true;
        Stack<String> stack = new Stack<>();

        String[] split = str.split("");

        for (String s : split) {
            if (stack.isEmpty()) {
                if (s.equals("}") || s.equals("]") || s.equals(")"))
                    return false;
                stack.add(s);
            }
            else {
                if (check(stack.peek(), s))
                    stack.pop();
                else {
                    stack.add(s);
                }
            }
        }

        return stack.isEmpty();

    }

    public static boolean check(String peek, String next) {
        switch (peek) {
            case "{":
                return next.equals("}");
            case "[":
                return next.equals("]");
            case "(":
                return next.equals(")");
        }
        return false;
    }
}
