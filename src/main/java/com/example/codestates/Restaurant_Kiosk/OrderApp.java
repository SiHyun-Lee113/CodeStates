package com.example.codestates.Restaurant_Kiosk;

import com.example.codestates.Restaurant_Kiosk.Product.ProductRepository;
import javafx.scene.input.Mnemonic;

import java.util.Scanner;

public class OrderApp {
    private Menu menu;
    private ProductRepository productRepository;
    private Order order;

    public OrderApp(Menu menu, ProductRepository productRepository, Order order) {
        this.menu = menu;
        this.productRepository = productRepository;
        this.order = order;
    }

    public void start() {
        order.makeOrder();
    }
}
