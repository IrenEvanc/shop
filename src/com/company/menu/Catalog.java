package com.company.menu;

import com.company.Category;
import com.company.Product;
import com.company.User;
import com.company.helper.Helper;

import java.util.ArrayList;
import java.util.Collections;

import static com.company.Main.fileCategory;
import static com.company.Main.fileUser;
import static com.company.menu.Menu.goToMenu;

public class Catalog {
    private String file;
    private ArrayList<Catalog> catalogs;
    private static String CatalogMenu =
            "1 - Список категорий товаров\n" +
//            "2 - Выбрать категорию товара\n" +
            "0- Вернуться в главное меню";

    public Catalog (String file, ArrayList<Catalog> catalogs) {
        this.file = file;
        this.catalogs = catalogs;
    }

    public static ArrayList<Category> initialize () {
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> products1 = new ArrayList<>();
        Product product1 = new Product("Молоко", 100, 3);
        Product product2 = new Product("Йогурт", 150, 3);
        Product product3 = new Product("Сыр   ", 250, 3);
        Product product4 = new Product("Свинина ", 550, 4);
        Product product5 = new Product("Курица  ", 450, 4);
        Product product6 = new Product("Говядина", 600, 4);
        Collections.addAll(products, product1, product2, product3);
        Category category1 = new Category("Молочные продукты", products);
        Collections.addAll(products1, product4, product5, product6);
        Category category2 = new Category("Мясные продукты", products1);
        ArrayList<Category> category = new ArrayList<>();
        Collections.addAll(category, category1, category2);
        return category;
    }

    public static void startCatalogMenu(User user) {
        CatalogMenu(user);
    }
    public static void startCatalogMenu() {
        OnlyShowCatalog();
    }

    private  static void OnlyShowCatalog () {
        boolean isAction = true;
        ArrayList<Category> categories = Menu.initFromFile(fileCategory);
        while (isAction) {
            System.out.println(CatalogMenu);
            switch (Helper.readInt()) {
                case 1:
                    showCategories(categories);
                    showProduct(categories);
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

    private static void showProduct (ArrayList<Category> categories) {
        boolean isAction = true;
        while (isAction) {
            System.out.println("Хотите посмотреть товары?");
            switch (Helper.readString()) {
                case "Yes":
                    int number;
                    System.out.println("\nВведите номер категории товаров");
                    number = Helper.readInt(0, categories.size() + 1);
                    Category category = categories.get(number - 1);
                    ArrayList<Product> products = category.getProducts();
                    Category.categoryIncludes(category, products);
                    break;
                case "No":
                    isAction = false;
                    System.out.println("Хотите вернуться на главную страницу?");
                    switch (Helper.readString()) {
                        case "Yes":
                            goToMenu();
                            break;
                        case "No":
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Введено некорректное значение");
                            break;
                    }
            }
        }
    }

    private static void CatalogMenu(User user) {
        boolean isAction = true;
        ArrayList<Category> categories = Menu.initFromFile(fileCategory);
        ArrayList<User> users = User.initFromFile(fileUser);
        while (isAction) {
            System.out.println(CatalogMenu);
            switch (Helper.readInt()) {
                case 1:
                    showCategories(categories);
                    choice(categories, user, users);
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

    static void showCategories (ArrayList<Category> categories) {
        int i=1;
        for (Category c: categories) {
            System.out.println(i+". "+ c.getName());
            i++;
        }
    }

    private static void choice (ArrayList<Category> categories, User user, ArrayList<User> users) {
        boolean isAction = true;
        while (isAction) {
            System.out.println("Хотите посмотреть товары?");
            switch (Helper.readString()) {
                case "Yes":
                    selectCategories(categories, user, users);
                    break;
                case "No":
                    isAction = false;
                    System.out.println("Хотите вернуться на главную страницу?");
                    switch (Helper.readString()) {
                        case "Yes":
                            goToMenu();
                            break;
                        case "No":
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Введено некорректное значение");
                            break;
                    }
            }
        }
    }

    public static void selectCategories(ArrayList<Category> categories, User user, ArrayList<User> users) {
        int number;
        System.out.println("\nВведите номер категории товаров");
        number = Helper.readInt(0, categories.size() + 1);
        Category category = categories.get(number - 1);
        ArrayList<Product> products = category.getProducts();
        Category.categoryIncludes(category, products);
        System.out.println("Хотите добавить товар в корзину?");
        switch (Helper.readString()) {
            case "Yes":
                BasketMenu.selectProduct(category, user);
                User.saveToFile(users, fileUser);
                break;
            case "No":
                System.exit(0);
                break;
            default:
                System.out.println("Введено некорректное значение");
                break;
        }
    }

}


