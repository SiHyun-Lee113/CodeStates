package com.example.codestates.BurgerQueen;

import com.example.codestates.BurgerQueen.Product.Product;
import com.example.codestates.BurgerQueen.Product.SubProduct.Drink;
import com.example.codestates.BurgerQueen.Product.SubProduct.Hamburger;
import com.example.codestates.BurgerQueen.Product.SubProduct.Side;

public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }

    public void printMenu() {
        System.out.println("[๐ป] ๋ฉ๋ด");
        System.out.println("-".repeat(60));


        printHamburgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println("๐งบ (0) ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("๐ฆ (+) ์ฃผ๋ฌธํ๊ธฐ");
        System.out.println("-".repeat(60));
        System.out.print("[๐ฃ] ๋ฉ๋ด๋ฅผ ์ ํํด์ฃผ์ธ์ : ");
    }

    public void printEachMenu(Product product, boolean printPrice) {
        if (printPrice )System.out.println(product);
        else System.out.printf("   (%d) %s %5dKcal\n", product.getId(), product.getName(), product.getKcal());
    }

    public void printDrinks(boolean printPrice) {
        System.out.println("๐ฅค ์๋ฃ");
        for (Product product : products) {
            if (product instanceof Drink)
                printEachMenu(product, printPrice);
        }
        System.out.println();
    }

    public void printSides(boolean printPrice) {
        System.out.println("๐ ์ฌ์ด๋");
        for (Product product : products) {
            if (product instanceof Side)
                printEachMenu(product, printPrice);
        }
        System.out.println();
    }

    public void printHamburgers(boolean printPrice) {
        System.out.println("๐ ํ๋ฒ๊ฑฐ");
        for (Product product : products) {
            if (product instanceof Hamburger)
                printEachMenu(product, printPrice);
        }
        System.out.println();
    }

}
