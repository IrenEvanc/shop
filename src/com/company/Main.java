package com.company;

import com.company.menu.Catalog;
import com.company.menu.Menu;

import java.util.ArrayList;

import static com.company.menu.Authorization.initializeUser;
import static com.company.menu.Menu.menu;

public class Main {
    public final static String fileCategory = "Category.txt";
    public final static String fileUser = "User.txt";

    public static void main(String[] args) {

        ArrayList<Category> categories = Menu.initFromFile(fileCategory);
        if (categories.size() == 0) {
            categories = Catalog.initialize();
            Menu.saveToFile(categories, fileCategory);
        }

        ArrayList<User> users = User.initFromFile(fileUser);
        if (users.size() == 0) {
            users = initializeUser();
            User.saveToFile(users, fileUser);

        }
        System.out.println(users);

        menu(users);
    }
}



