package com.example.codestates.BurgerQueen;

import com.example.codestates.BurgerQueen.Product.Cart;
import com.example.codestates.BurgerQueen.Product.Product;
import com.example.codestates.BurgerQueen.Product.ProductRepository;
import com.example.codestates.BurgerQueen.discount.Discount;
import com.example.codestates.BurgerQueen.discount.DiscountCondition;
import com.example.codestates.BurgerQueen.discount.discountCondition.CozDiscountCondition;
import com.example.codestates.BurgerQueen.discount.discountCondition.KidDiscountCondition;
import com.example.codestates.BurgerQueen.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.example.codestates.BurgerQueen.discount.discountPolicy.FixedRateDiscountPolicy;

import java.util.Scanner;

public class OrderApp {

    private ProductRepository productRepository;
    private Menu menu;
    private Cart cart;
    private Order order;

    public OrderApp(ProductRepository productRepository, Menu menu, Cart cart, Order order) {
        this.productRepository = productRepository;
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        System.out.println("🍔 BurgerQueen Order Service");
        while (true) {
            menu.printMenu();
            String input = sc.nextLine();

            if (input.equals("+")) {
                order.makeOrder();
                break;
            }
            else {
                int menuNumber = Integer.parseInt(input);

                if (menuNumber == 0) cart.printCart();
                else if (1 <= menuNumber && menuNumber <= productRepository.getAllProducts().length)
                    cart.addToCart(menuNumber);

            }
        }
    }
}
