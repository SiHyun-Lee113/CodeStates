package com.example.codestates.Restaurant_Kiosk.Product;

public class ProductRepository {
    private Product[] products = {
            new Product("1", "김밥", 1000),
            new Product("2", "계란 김밥", 1500),
            new Product("3", "충무 김밥", 1000),
            new Product("4", "떡볶이", 2000),
    };

    public Product[] getAllproducts () {
        return products;
    }
}
