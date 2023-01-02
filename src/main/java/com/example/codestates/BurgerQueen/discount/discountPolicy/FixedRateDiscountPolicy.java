package com.example.codestates.BurgerQueen.discount.discountPolicy;

import com.example.codestates.BurgerQueen.discount.DiscountPolicy;

public class FixedRateDiscountPolicy implements DiscountPolicy {
    private int discountRate;

    public FixedRateDiscountPolicy(int discountRate) {
        this.discountRate = discountRate;
    }

    public int calculateDiscountedPrice(int price) {
        return price - (price * discountRate / 100);
    }
}
