package com.example.codestates.BurgerQueen;

import com.example.codestates.BurgerQueen.Product.Cart;
import com.example.codestates.BurgerQueen.discount.Discount;
import com.example.codestates.BurgerQueen.discount.DiscountCondition;
import com.example.codestates.BurgerQueen.discount.discountCondition.CozDiscountCondition;
import com.example.codestates.BurgerQueen.discount.discountCondition.KidDiscountCondition;
import com.example.codestates.BurgerQueen.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.example.codestates.BurgerQueen.discount.discountPolicy.FixedRateDiscountPolicy;

public class Order {
    private Cart cart;
    private Discount discount;

    public Order(Cart cart, Discount discount) {
        this.cart = cart;
        this.discount = discount;
    }

    public void makeOrder() {
        discount.checkAllDiscountConditions();

        System.out.println("[ð£] ì£¼ë¬¸ì´ ìë£ëììµëë¤. ");
        System.out.println("[ð£] ì£¼ë¬¸ ë´ì­ì ë¤ìê³¼ ê°ìµëë¤. ");
        System.out.println("-".repeat(60));

        cart.printCartItemDetails();

        int totalPrice = cart.calculateTotalPrice();
        int finalPrice = discount.discount(totalPrice);

        System.out.println("-".repeat(60));
        System.out.printf("ê¸ì¡ í©ê³\t\t : %dì\n", totalPrice);
        System.out.printf("í ì¸ ì ì© ê¸ì¡\t : %dì\n", finalPrice);

    }
}
