package com.example.codestates.Restaurant_Kiosk;

import com.example.codestates.Restaurant_Kiosk.Product.Product;

public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }

    public int getPrice(String input) {
        int price = 0;

        for (Product product : products) {
            if (input.equals(product.getId()))
                return product.getPrice();
        }

        return price;
    }

    public void printMenu() {
        System.out.println("[안내] 원하시는 메뉴의 번호를 입력해 주세요");
        for (Product product : products) {
            System.out.print(product + " ");
        }
        System.out.println();
    }

    public boolean menuCheck(String input) {
        boolean check = false;

        for (Product product : products) {
            if (input.equals(product.getId()))
                return true;
        }

        return check;
    }
}
