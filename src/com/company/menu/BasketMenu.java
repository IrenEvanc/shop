package com.company.menu;

import com.company.Basket;
import com.company.Category;
import com.company.Product;
import com.company.User;
import com.company.helper.Helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static com.company.Main.fileUser;

public class BasketMenu {
    public final static String fileBasket = "Basket.txt";
    private String file;
    private ArrayList<Product> purchasedProducts;
    private static String BasketMenu =
            "1 - Отобразить корзину\n" +
            "2 - Редактировать корзину\n" + // изменить количество и удалить
            "3 - Купить все\n" +
            "0 - Вернуться в каталог";

    public BasketMenu (String file, ArrayList<Product> products) {
        this.file = file;
        this.purchasedProducts = purchasedProducts;
    }

     private static void BasketMenu(ArrayList<Product> products, Product product, User user) {
        boolean isAction = true;
        ArrayList<User> users = User.initFromFile(fileUser);
        System.out.println("");
        while (isAction) {
            System.out.println(BasketMenu);
            switch (Helper.readInt()) {
                case 1:
                    showBasket(user);
                    User.saveToFile(users, fileUser);
                break;
//                case 2:
//                    editBasket();
//                    break;
//                case 3:
//                    buyAll();
//                    break;
                case 0:
                    isAction = false;
                    Catalog.startCatalogMenu(user);
                    break;
                default:
                    System.out.println("Введено некорректное значение");
                    break;
            }
        }
    }
    public static void selectProduct (Category category, User user) {
        ArrayList<Product> products = category.getProducts();
        System.out.println("Введите номер продукта");
        int i = Helper.readInt(0, products.size() + 1);
        Product product = products.get(i - 1);
        System.out.println("Наименование выбранного товара: " + product.getName()+ "   Цена:" + product.getPrice());
        user.putProductsInBasket(product);
        System.out.println("Хотите выбрать еще товар?");
        switch (Helper.readString()) {
            case "Yes":
                Catalog.startCatalogMenu(user);
                break;
            case "No":
                BasketMenu (products, product, user);
                break;
        }
    }

    private static void showBasket(User user) {
        Basket basket = user.getBasket();
        ArrayList<Product> products = basket.getPurchasedProducts();
        System.out.println("Корзина\n");
        int i = 1;
        System.out.println("№ " + " Наименование товара " + "Стоимость");
        for (Product product : products) {
            System.out.println(i + ". " + "       " + product.getName() + "       " + " " + product.getPrice() + "\n");
            i++;
        }
        System.out.println();
    }
}
