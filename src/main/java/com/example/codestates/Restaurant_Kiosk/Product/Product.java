package com.example.codestates.Restaurant_Kiosk.Product;

public class Product {
    private String id;
    private String name;
    private int price;

    @Override
    public String toString() {
        return "[" + this.id + "] " + this.name + "(" + this.price + "원)";
    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
