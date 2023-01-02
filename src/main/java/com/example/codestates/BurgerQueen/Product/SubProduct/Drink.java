package com.example.codestates.BurgerQueen.Product.SubProduct;

import com.example.codestates.BurgerQueen.Product.Product;

public class Drink extends Product {

    private boolean hasStraw;
    public Drink(int id, String name, int price, int kcal, boolean hasStraw) {
        super(id, name, price, kcal);
        this.hasStraw = hasStraw;
    }

    public Drink(Drink drink) {
        super(drink.getName(), drink.getPrice(), drink.getKcal());
        this.hasStraw = drink.isHasStraw();
    }

    public boolean isHasStraw() {
        return hasStraw;
    }

    public void setHasStraw(boolean hasStraw) {
        this.hasStraw = hasStraw;
    }
}
