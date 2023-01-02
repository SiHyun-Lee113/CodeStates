package com.example.codestates.BurgerQueen.Product;

import com.example.codestates.BurgerQueen.Product.SubProduct.Drink;
import com.example.codestates.BurgerQueen.Product.SubProduct.Hamburger;
import com.example.codestates.BurgerQueen.Product.SubProduct.Side;

public class ProductRepository {
    private Product[] products = {
            new Hamburger(1, "새우버거", 3500, 500, false, 4500),
            new Hamburger(2, "치킨버거", 4000, 600, false, 5000),
            new Side(3, "감자튀김", 1000, 300, 1),
            new Side(4, "언니언링", 1000, 300, 1),
            new Drink(5, "코카콜라", 1000, 200, true),
            new Drink(6, "제로콜라", 1000, 0, true)
    };

    public Product[] getAllProducts() {
        return products;
    }

    public Product findById(int productId) {
        for (Product element : products) {
            if (element.getId() == productId)
                return element;
        }
        return null;
    }
}
