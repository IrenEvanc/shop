//package com.company.helper;
//
//import main.entity.Category;
//import main.entity.Product;
//import main.entity.User;
//import com.company.menu.Menu;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//import static com.company.Main.fileCategory;
//import static com.company.Main.fileUser;
//
//public final class Loading {
//
//    public static ArrayList<Category> initialize() {
//        ArrayList<Product> products = new ArrayList<>();
//        ArrayList<Product> products1 = new ArrayList<>();
//        Product product1 = new Product("Молоко", 100, 3);
//        Product product2 = new Product("Йогурт", 150, 3);
//        Product product3 = new Product("Сыр   ", 250, 3);
//        Product product4 = new Product("Свинина ", 550, 4);
//        Product product5 = new Product("Курица  ", 450, 4);
//        Product product6 = new Product("Говядина", 600, 4);
//        Collections.addAll(products, product1, product2, product3);
//        Category category1 = new Category("Молочные продукты", products);
//        Collections.addAll(products1, product4, product5, product6);
//        Category category2 = new Category("Мясные продукты", products1);
//        ArrayList<Category> category = new ArrayList<>();
//        Collections.addAll(category, category1, category2);
//        return category;
//    }
//
//    public static ArrayList<User> initializeUser() {
//        ArrayList<User> user = new ArrayList<>();
//        User user1 = new User();
//        user1.setLogin("Sony");
//        user1.setPassword("1234");
//        User user2 = new User();
//        user2.setLogin("Eva");
//        user2.setPassword("3654");
//        Collections.addAll(user, user1, user2);
//        return user;
//    }
//
////    public static ArrayList<User> getUsers() {
////        ArrayList<User> users = User.initFromFile(fileUser);
////        if (users.size() == 0) {
////            users = Loading.initializeUser();
////            User.saveToFile(users, fileUser);
////        }
////        return users;
////    }
////    static {
////        System.out.println(getUsers());
////
////    }
//    public static ArrayList<Category> getCategories() {
//        ArrayList<Category> categories = Menu.initFromFile(fileCategory);
//        if (categories.size() == 0) {
//            categories = Loading.initialize();
//            Menu.saveToFile(categories, fileCategory);
//        }
//        return categories;
//    }
//}
