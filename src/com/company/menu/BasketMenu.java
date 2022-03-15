package com.company.menu;

import com.company.Basket;
import com.company.Category;
import com.company.Product;
import com.company.User;
import com.company.helper.Helper;
import com.company.helper.Loading;

import java.util.*;

import static com.company.Main.fileUser;

public class BasketMenu {

    private static String BasketMenu =
            "1 - Отобразить корзину\n" +
                    "2 - Редактировать корзину\n" + // изменить количество и удалить
                    "3 - Купить все\n" +
                    "0 - Вернуться в каталог";
    private static String EditBasketMenu =
            "1 - Изменить количество\n" +
                    "2 - Удалить товар\n" +
                    "0 - Вернуться в каталог";

    public static void goBasketMenu(User user) {
        BasketMenu(Loading.getUsers(), user);
    }

    private static void BasketMenu(ArrayList<User> users, User user) {
        boolean isAction = true;
        System.out.println("");
        while (isAction) {
            System.out.println(BasketMenu);
            switch (Helper.readInt()) {
                case 1:
                    showBasket(user);
                    break;
                case 2:
                    editBasket(user, users);
                    break;
                    //ну тут думаю ничего не надо комментировать)))
//                case 3:
//                    buyAll();
//                    break;
                case 0:
                    isAction = false;
                    break;
                default:
                    System.out.println("Введено некорректное значение");
                    break;
            }
        }
    }

    public static void editBasket(User user, ArrayList<User> users) {
        boolean isAction = true;
        System.out.println("");
        showBasket(user);

        //а перед тем как редактировать мне не надо чтоб на экран вывели собственно саму корзину?
        while (isAction) {
            System.out.println(EditBasketMenu);
            switch (Helper.readInt()) {
                case 1:
                    changeNumberOfProduct(user, users);
                    break;
                case 2:
                    deleteProductFromBasket(user, users);
                    break;
                case 0:
                    isAction = false;
                    break;
                default:
                    System.out.println("Введено некорректное значение");
                    break;
            }
        }
    }

    public static void selectProduct(User user, ArrayList<Category> categories, ArrayList<Product> products, ArrayList<User> users) {
        users.remove(user);
        System.out.println("Введите номер продукта");
        int i = Helper.readInt(0, products.size() + 1);
        Product product = products.get(i - 1);
        System.out.println("Введите желаемое количество товара");
        Number number = Helper.readInt();
        user.putProductInBasket(product, number);
        // Ой, а что это ты такое сделала? Да это же костыль) выкинь из продуктов намбер, очень срочно)
        System.out.println("Наименование выбранного товара: " + product.getName() + "   Цена:" + product.getPrice() + "   Количество:" + number);
        System.out.println("Хотите выбрать еще товар?");
        switch (Helper.readString()) {
            case "Y":
                Catalog.startCatalogMenu(user, categories);
                break;
            case "N":
                goBasketMenu(user);
                break;
        }
        Collections.addAll(users, user);
        User.saveToFile(users, fileUser);
    }

    public static void showBasket(User user) {
        Basket basket = user.getBasket();
        HashMap<Product, Number> products = basket.getProductsInBasket();
        System.out.println("Корзина\n");
        int i = 1;
        int sum = 0;
        System.out.format("\t %1$-5s %2$-30s  %3$-10s  %4$-10s\n","№ "," Наименование товара ","Стоимость","Количество");
        for (Map.Entry<Product, Number> product : products.entrySet()) {
            System.out.format("\t %1$-5s %2$-30s  %3$-10s  %4$-10s\n", i + ". ", product.getKey().getName(), product.getKey().getPrice(), product.getValue());
            i++;
            sum=sum+((int)product.getKey().getPrice()*(int)product.getValue());
        }
        System.out.format("\t %1$-45s %2$-10s\n","Общая стоимость товара", sum);
        System.out.println();
    }

    private static Product selectProduct(User user) {
        HashMap<Product, Number> products = user.getBasket().getProductsInBasket();
        Set<Product> products1 = products.keySet();
        System.out.println("\nВведите номер товара, который желаете изменить/удалить");
        Product product = (Product) products1.toArray()[Helper.readInt()-1];
        return product;
    }

    private static void changeNumberOfProduct (User user, ArrayList<User> users){
        Product product = selectProduct(user);
        HashMap<Product, Number> products = user.getBasket().getProductsInBasket();
        System.out.println("Введите желаемое количество товара");
        products.replace (product, Helper.readInt());
        users.remove(user);
        Collections.addAll(users, user);
        User.saveToFile(users, fileUser);
    }

    private static void deleteProductFromBasket (User user, ArrayList<User> users){
        Product product = selectProduct(user);
        HashMap<Product, Number> products = user.getBasket().getProductsInBasket();
        products.remove(product);
        users.remove(user);
        Collections.addAll(users, user);
        User.saveToFile(users, fileUser);
    }
}
