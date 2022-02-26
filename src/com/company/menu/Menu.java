package com.company.menu;


import com.company.Category;
import com.company.User;
import com.company.helper.Helper;
import com.company.helper.Loading;

import java.io.*;
import java.util.ArrayList;


public class Menu {


    private static String Menu =
            "1 - Авторизация\n" +
            "2 - Каталог товара\n" +
            "0 - Выход";

    public static void goToMenu () {
        menu(Loading.getUsers(), Loading.getCategories());
    }

    private static void menu(ArrayList<User> users, ArrayList<Category> categories) {
        while (true) {
            System.out.println(Menu);
           switch (Helper.readInt()) {
                case 1:
                    //вот тут идёт некая авторизация, а не должен ли в качестве её результата возвращаться пользователь?
                    //а вот дальше уже для него некий движ-Париж, выглядит будто бы так
                    // а вот перед тем как дать ему каталог проверяем авторизованный или нет, и показываем либо полное либо урезанное
                    Authorization.startAuthorizationMenu(users, categories);
                    break;
                case 2:
                    System.out.println("Добро пожаловать в каталог!");
                    Catalog.startCatalogMenu(categories);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
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

}


//    static void printCategory (ArrayList<Category> categories) {
//        int i=1;
//        for (Category c: categories) {
//            System.out.println(i+". "+ c.getName()+c);
//            i++;
//        }
//    }
//    public static Category getCategory(ArrayList<Category> categories){
//        ArrayList <Product> products = Category.input();
//       Category category = new Category(Helper.readString(), products);
//        return category;
//    }


//    public static String getBasketMenu() {
//        return BasketMenu;
//    }
//}
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