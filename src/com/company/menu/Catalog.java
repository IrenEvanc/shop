package com.company.menu;

import com.company.Category;
import com.company.Product;
import com.company.User;
import com.company.helper.Helper;
import com.company.helper.Loading;

import java.util.ArrayList;

import static com.company.menu.Menu.goToMenu;

public class Catalog {

    private static String CatalogMenu =
            "1 - Список категорий товаров\n" +
            "2 - Показать корзину\n" +
                    "0- Вернуться в главное меню";
    private static String CatalogMenu1 =
            "1 - Список категорий товаров\n" +
                    "0- Вернуться в главное меню";

    public static void startCatalogMenu(User user, ArrayList<Category> categories) {
        CatalogMenu(user, categories, Loading.getUsers());
    }

    public static void startCatalogMenu(ArrayList<Category> categories) {
        OnlyShowCatalog(categories, Loading.getUsers());
    }

    private static void OnlyShowCatalog(ArrayList<Category> categories, ArrayList<User> users) {
        boolean isAction = true;
        while (isAction) {
            System.out.println(CatalogMenu1);
            switch (Helper.readInt()) {
                case 1:
                    showCategories(categories);
                    choice(categories, null, users);
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

    private static void CatalogMenu(User user, ArrayList<Category> categories, ArrayList<User> users) {
        boolean isAction = true;
        while (isAction) {
            System.out.println(CatalogMenu);
            switch (Helper.readInt()) {
                case 1:
                    showCategories(categories);
                    choice(categories, user, users);
                    break;
                case 2:
                    BasketMenu.showBasket(user, categories);
                    BasketMenu.goBasketMenu(user, categories);
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

    static void showCategories(ArrayList<Category> categories) {
        int i = 1;
        for (Category c : categories) {
            System.out.println(i + ". " + c.getName());
            i++;
        }
    }

    private static void choice(ArrayList<Category> categories, User user, ArrayList<User> users) {
        boolean isAction = true;
        while (isAction) {
            System.out.println("Хотите посмотреть товары?");
            switch (Helper.readString()) {
                case "Y":
                    showProductsFromCategory(categories, user, users);
                    break;
                case "N":
                    isAction = false;
                    System.out.println("Хотите вернуться на главную страницу?");
                    switch (Helper.readString()) {
                        case "Y":
                            goToMenu();
                            break;
                        case "N":
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Введено некорректное значение");
                            break;
                    }
            }
        }
    }

    private static Category selectCategories(ArrayList<Category> categories) {
        int number;
        System.out.println("\nВведите номер категории товаров");
        number = Helper.readInt(0, categories.size() + 1);
        Category category = categories.get(number - 1);
        return category;
    }

    public static ArrayList<Product> productsFromCategoties(Category category) {
        return category.getProducts();
    }

    public static void showProductsFromCategory(ArrayList<Category> categories, User user, ArrayList<User> users) {
        Category category = selectCategories(categories);
        ArrayList<Product> products = productsFromCategoties(category);
        System.out.println("Категория " + category.getName() + " включает следующие товары:\n");
        int i = 1;
        System.out.println("№ " + " Наименование товара " + "Стоимость");
        for (Product product : products) {
            System.out.println(i + ". " + "       " + product.getName() + "       " + " " + product.getPrice() + "\n");
            i++;
        }
        System.out.println();

        if (user!= null) {
        addProductToBasket(categories, products, user, users);}
    }

    public static void addProductToBasket(ArrayList<Category> categories,  ArrayList<Product> products, User user, ArrayList<User> users) {
        System.out.println("Хотите добавить товар в корзину?");
        switch (Helper.readString()) {
            case "Y":
                BasketMenu.selectProduct(user, categories, products, users);
                break;
            case "N":
                System.exit(0);
                break;
            default:
                System.out.println("Введено некорректное значение");
                break;
        }
    }
}


