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

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        cart.printCartItemDetails();

        int totalPrice = cart.calculateTotalPrice();
        int finalPrice = discount.discount(totalPrice);

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계\t\t : %d원\n", totalPrice);
        System.out.printf("할인 적용 금액\t : %d원\n", finalPrice);

    }
}
