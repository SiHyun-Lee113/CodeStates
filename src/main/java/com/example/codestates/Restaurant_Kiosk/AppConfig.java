package com.example.codestates.Restaurant_Kiosk;

import com.example.codestates.Restaurant_Kiosk.Product.ProductRepository;

public class AppConfig {

    public ProductRepository productRepository() {
        return new ProductRepository();
    }
    public Menu menu() {
        return new Menu(productRepository().getAllproducts());
    }
    public Order order() {
        return new Order(productRepository(), menu());
    }
}
