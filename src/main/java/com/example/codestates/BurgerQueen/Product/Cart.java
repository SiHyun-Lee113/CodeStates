package com.example.codestates.BurgerQueen.Product;

import com.example.codestates.BurgerQueen.Menu;
import com.example.codestates.BurgerQueen.Product.SubProduct.BurgerSet;
import com.example.codestates.BurgerQueen.Product.SubProduct.Drink;
import com.example.codestates.BurgerQueen.Product.SubProduct.Hamburger;
import com.example.codestates.BurgerQueen.Product.SubProduct.Side;

import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];   //장바구니
    private Scanner sc = new Scanner(System.in);

    private ProductRepository productRepository;
    private Menu menu;

    public Cart(ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

    public void addToCart(int productId) {
        Product product = productRepository.findById(productId);

        chooseOption(product);

        if (product instanceof Hamburger) {
            Hamburger hamburger = (Hamburger) product;
            if (hamburger.isBurgerSet())
                product = composeSet(hamburger);
        }

        Product newProduct;
        if (product instanceof Hamburger) newProduct = new Hamburger((Hamburger) product);
        else if (product instanceof Side) newProduct = new Side((Side) product);
        else if (product instanceof Drink) newProduct = new Drink((Drink) product);
        else newProduct = new BurgerSet((BurgerSet) product);

        Product[] newItems = new Product[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[newItems.length - 1] = newProduct;
        items = newItems;

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", product.getName());
    }

    private void chooseOption(Product product) {
        String input;

        if (product instanceof Hamburger) {
            System.out.printf("단품으로 주문하시겠어요? (1)_단품(%d) (2)_세트(%d)\n",
                    product.getPrice(),
                    ((Hamburger) product).getBurgerSetPrice());
            input = sc.nextLine();
            if (input.equals("2"))
                ((Hamburger) product).setBurgerSet(true);
            else if (input.equals("1")){
                ((Hamburger) product).setBurgerSet(false);

            }
        } else if (product instanceof Side) {
            System.out.println("케첩은 몇개가 필요하신가요?");
            input = sc.nextLine();
            ((Side) product).setKetchup(Integer.parseInt(input));
        } else if (product instanceof Drink) {
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            input = sc.nextLine();
            if (input.equals(2))
                ((Drink) product ).setHasStraw(false);
        }
    }

    public BurgerSet composeSet(Hamburger hamburger) {
        System.out.println("사이드를 골라주세요");
        menu.printSides(false);

        String sideId = sc.nextLine();
        Side side = (Side) productRepository.findById(Integer.parseInt(sideId));
        chooseOption(side);

        System.out.println("음료를 골라주세요.");
        menu.printDrinks(false);

        String drinkId = sc.nextLine();
        Drink drink = (Drink) productRepository.findById(Integer.parseInt(drinkId));
        chooseOption(drink);

        String name = hamburger.getName() + "세트";
        int price = hamburger.getBurgerSetPrice();
        int kcal = hamburger.getKcal() + side.getKcal() + drink.getKcal();

        return new BurgerSet(name, price, kcal, hamburger, side, drink);
    }
    public void printCart() {
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", calculateTotalPrice());
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void printCartItemDetails() {
        for (Product item : items) {
            if (item instanceof Hamburger)
                System.out.printf("  %s %6d원 (단품)\n",
                        item.getName(),
                        item.getPrice());
            else if (item instanceof Side)
                System.out.printf("  %s %6d원 (캐첩 %d개)\n",
                        item.getName(),
                        item.getPrice(),
                        ((Side) item).getKetchup());
            else if (item instanceof Drink)
                System.out.printf("  %s %6d원 (빨대 %s)\n",
                        item.getName(),
                        item.getPrice(),
                        ((Drink) item).isHasStraw() ? "있음" : "없음");
            else if (item instanceof BurgerSet) {
                BurgerSet burgerSet = (BurgerSet) item;
                System.out.printf(
                        "  %s %6d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                        item.getName(),
                        item.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().isHasStraw() ? "있음" : "없음"
                );
            }
                ;
        }
    }

}
