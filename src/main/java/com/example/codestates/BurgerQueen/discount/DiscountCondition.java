package com.example.codestates.BurgerQueen.discount;

public interface DiscountCondition {
    void checkDiscountCondition();
    int applyDiscount(int price);
    boolean isSatisfied();
}
