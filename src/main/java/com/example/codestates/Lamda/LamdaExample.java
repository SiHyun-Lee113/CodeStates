package com.example.codestates.Lamda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class LamdaExample {
    public static void main(String[] args) {
        Calculate calculate = (a, b) -> a + b;

        System.out.println(calculate.sum(10, 29));

        FI fi;
        fi = () -> {
            String str = "test";
            System.out.println(str + "method");
        };
        fi.accept();

        fi = () -> System.out.println("second method");
        fi.accept();

        Value_return vr;
        vr = (a, b) -> {
            int result = a + b;
            return result;
        };
        System.out.println("vr = " + vr.accept(2, 3));

        vr = (a, b) -> a + b;
        System.out.println("vr = " + vr.accept(2, 3));

        vr = Math::pow;
        System.out.println("vr = " + vr.accept(2, 3));

        Function<String, Member> function1 = Member::new;
        Member member1 = function1.apply("lee");

        BiFunction<String, String, Member> function2 = Member::new;
        Member member2 = function2.apply("lee", "sihyun");

    }

    @FunctionalInterface
    public interface Value_return {
        public double accept(int x, int y);
    }

    @FunctionalInterface
    public interface FI {
        public void accept();
    }

    @FunctionalInterface
    interface Calculate {
        public abstract int sum (int a, int b);
    }
}
