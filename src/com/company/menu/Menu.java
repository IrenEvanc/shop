package com.company.menu;


import com.company.Category;
import com.company.Product;
import com.company.User;
import com.company.helper.Helper;

import java.io.*;
import java.util.ArrayList;

import static com.company.Main.fileCategory;
import static com.company.Main.fileUser;

public class Menu {

    private String file;
    private ArrayList<Product> products;

    private static String Menu =
            "1 - Авторизация\n" +
            "2 - Каталог товара\n" +
            "0 - Выход";

    private static String BasketMenu = "Выберете действие:\n" +
            "1 - Положить товар в корзину\n" +
            "2 - Отобразить корзину\n" +
            "3 - Редактировать корзину\n" +
            "4 - Удалить товар\n" +
            "5 - Купить все\\n\" +" +
            "0 - Вернуться в каталог";

    public Menu (String file, ArrayList<Product> products) {
        this.file = file;
        this.products = products;
    }

    public static void goToMenu () {
        ArrayList<User> users = User.initFromFile(fileUser);
        menu(users);
    }

    public static void menu(ArrayList<User> users) {
        while (true) {
            System.out.println(Menu);
           switch (Helper.readInt()) {
                case 1:
                    Authorization.startAuthorizationMenu(users);
                    break;
                case 2:
                    System.out.println("Добро пожаловать в каталог!");
                    Catalog.startCatalogMenu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    static void printCategory (ArrayList<Category> categories) {
        int i=1;
        for (Category c: categories) {
            System.out.println(i+". "+ c.getName()+c);
            i++;
        }
    }
    public static Category getCatagory(ArrayList<Category> categories){
        ArrayList <Product> products = Category.input();
       Category category = new Category(Helper.readString(), products);
        return category;
    }
    public static ArrayList<Category> initFromFile(String file){
        ArrayList<Category> categories = new ArrayList<Category>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            categories = (ArrayList<Category>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
    public static void saveToFile(ArrayList<Category> categories, String file){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false));
            oos.writeObject(categories);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getBasketMenu() {
        return BasketMenu;
    }
}
//    public static void menu(ArrayList<Category> categories, String file) {
//        while (true) {
//            System.out.println(Menu);
//            switch (Helper.readInt()) {
//                case 1:
//                    printCategory(categories);
//                    if (categories.size() == 0) {
//                        System.out.println("Нет категорий");
//                    }
//                    break;
//                case 2:
//                    getCatagory(categories);
//                    saveToFile(categories, file);
//                    System.out.println("Объект сохранен");
//                    break;
//                case 0:
//                    System.exit(0);
//                    break;
//            }
//        }
//    }