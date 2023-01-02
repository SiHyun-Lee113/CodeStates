package com.example.codestates.training_ex;

public class Interface_ex {
    public static void main(String[] args) {
        CafeOwner cafeOwner = new CafeOwner();
        Customer customerA = new CustomerA();
        Customer customerB = new CustomerB();

        cafeOwner.givieItem(customerA);
        cafeOwner.givieItem(customerB);
    }
}

class CafeOwner {
    public void givieItem(Customer customer) {
        System.out.println("Item : " + customer.getOrder());
    }
}

interface Customer {
    String getOrder();

    static void test() {

    }
}

class CustomerA implements Customer {

    @Override
    public String getOrder() {
        return "a glass of iced americano";
    }
}
class CustomerB implements Customer {

    @Override
    public String getOrder() {
        return "a glass of coke";
    }
}