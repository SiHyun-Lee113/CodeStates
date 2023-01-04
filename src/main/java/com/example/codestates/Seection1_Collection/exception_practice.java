package com.example.codestates.Seection1_Collection;

public class exception_practice {
    public static void main(String[] args) {
        try {
            throwException();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    static void throwException() throws ClassNotFoundException, NullPointerException {
        Class.forName("java.lang.StringX");
    }
}
