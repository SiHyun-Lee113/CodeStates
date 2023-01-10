package com.example.codestates.Thread;

public class ThreadExample1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
