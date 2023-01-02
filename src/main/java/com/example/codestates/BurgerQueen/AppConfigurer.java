package com.example.codestates.BurgerQueen;

import com.example.codestates.BurgerQueen.Product.Cart;
import com.example.codestates.BurgerQueen.Product.ProductRepository;
import com.example.codestates.BurgerQueen.discount.Discount;
import com.example.codestates.BurgerQueen.discount.DiscountCondition;
import com.example.codestates.BurgerQueen.discount.discountCondition.CozDiscountCondition;
import com.example.codestates.BurgerQueen.discount.discountCondition.KidDiscountCondition;
import com.example.codestates.BurgerQueen.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.example.codestates.BurgerQueen.discount.discountPolicy.FixedRateDiscountPolicy;

public class AppConfigurer {

    private Cart cart = new Cart(productRepository(), menu());

    public ProductRepository productRepository() {
        return new ProductRepository();
    }
    public Menu menu() {
        return new Menu(productRepository().getAllProducts());
    }

    public Cart cart() {
        return cart;
    }

    public Discount discount() {
        return new Discount(
                new DiscountCondition[]{
                        new CozDiscountCondition(new FixedRateDiscountPolicy(10)),
                        new KidDiscountCondition(new FixedAmountDiscountPolicy(500))
                });
    }

    public Order order() {
        return new Order(cart(), discount());
    }
}