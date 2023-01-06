package com.example.codestates.Restaurant_Kiosk;

import com.example.codestates.Restaurant_Kiosk.Product.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("[안내] 안녕하세요. 김밥천국에 오신 것을 환영합니다.");
        System.out.println("-".repeat(60));

        AppConfig appConfig = new AppConfig();

        OrderApp orderApp = new OrderApp(
                appConfig.menu(),
                appConfig.productRepository(),
                appConfig.order()
        );

        orderApp.start();




    }
}
