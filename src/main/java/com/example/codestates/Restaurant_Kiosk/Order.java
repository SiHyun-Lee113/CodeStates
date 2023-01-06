package com.example.codestates.Restaurant_Kiosk;

import com.example.codestates.Restaurant_Kiosk.Product.Product;
import com.example.codestates.Restaurant_Kiosk.Product.ProductRepository;

import java.util.Scanner;

public class Order {

    private ProductRepository productRepository;
    private Menu menu;

    public Order(ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

    public void makeOrder() {
        Scanner sc = new Scanner(System.in);

        menu.printMenu();
        String input = sc.nextLine();

        if (!menu.menuCheck(input)) {
            System.out.println("\n[안내] 메뉴에 포함된 번호를 입력하여 주새요.");

            menu.printMenu();
            input = sc.nextLine();
        }

        int price = 0;
        price = menu.getPrice(input);
        System.out.println("-".repeat(60));
        //메뉴 수량
        System.out.println("[안내] 선택하신 메뉴의 수량을 입력하여 주세요.");
        System.out.println("(최대 주문 가능 수량 : 99)");
        input = sc.nextLine();

        if (Integer.parseInt(input) >= 100) {
            System.out.println("[경고]" + input + "개는 입력하실 수 없습니다.");
            System.out.println("[경고]수량 선택 화면으로 돌아갑니다.");
            System.out.println("-".repeat(60));
            System.out.println("[안내] 선택하신 메뉴의 수량을 입력하여 주세요.");
            System.out.println("(최대 주문 가능 수량 : 99)");
            input = sc.nextLine();
        }

        price *= Integer.parseInt(input) ;
        System.out.println("[안내] 주문하신 메뉴의 총 금액은 " + price + "입니다.");
    }
}
