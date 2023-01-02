package com.example.codestates.BurgerQueen.discount.discountPolicy;

import com.example.codestates.BurgerQueen.discount.DiscountPolicy;

public class FixedAmountDiscountPolicy implements DiscountPolicy {
    private int discountAmount;

    public FixedAmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int calculateDiscountedPrice(int price) {
        return price - discountAmount;
    }
}
