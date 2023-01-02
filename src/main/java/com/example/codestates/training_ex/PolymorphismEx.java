package com.example.codestates.training_ex;

public class PolymorphismEx {
    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.buyCoffee(new Americano());
        customer.buyCoffee(new CaffeLatte());

        System.out.println("현재 잔액은 " + customer.money + "원 입니다.");

        Dog dog = new Dog();
        dog.cry();
        dog.play();
    }

    interface Animal { // 인터페이스 선언. public abstract 생략 가능.
        public abstract void cry();
    }

    interface Pet {
        void play();
    }

    static class Dog implements Animal, Pet { // Animal과 Pet 인터페이스 다중 구현
        public void cry(){ // 메서드 오버라이딩
            System.out.println("멍멍!");
        }

        public void play(){ // 메서드 오버라이딩
            System.out.println("원반 던지기");
        }
    }
    static class Coffee {
        int price;

        public Coffee(int price) {
            this.price = price;
        }
    }

    static class Americano extends Coffee {
        public Americano() {
            super(4000);
        }

        @Override
        public String toString() {
            return "Americano";
        }
    }
    static class CaffeLatte extends Coffee {
        public CaffeLatte() {
            super(5000);
        }

        @Override
        public String toString() {
            return "CaffeLatte";
        }
    }

    static class Customer {
        int money = 50000;

        void buyCoffee(Coffee coffee) {
            if(money < coffee.price) {
                System.out.println("잔액이 부족합니다.");
                return;
            }
            money -= coffee.price;
            System.out.println(coffee + "를 구매했습니다.");
        }
    }
}
