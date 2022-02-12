package com.company.menu;

import com.company.Basket;
import com.company.Category;
import com.company.Product;
import com.company.User;
import com.company.helper.Helper;
import com.company.menu.Menu;

import java.util.ArrayList;
import java.util.Collections;

import static com.company.Main.fileUser;
import static com.company.menu.Catalog.startCatalogMenu;

public class Authorization {
    private String file;
    private ArrayList <User> users;
    private static String AuthorizationMenu = "Выберете действие:\n" +
            "1 - Войти в систему\n" +
            "2 - Зарегистрироваться\n" +
            "0 - Вернуться в главное меню";


    public Authorization (String file, ArrayList <User> users) {
        this.file = file;
        this.users = users;
    }

    public static ArrayList<User> initializeUser () {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Product> products1 = new ArrayList<>();
        User user1 = new User("Sony", "1234");
        User user2 = new User("Eva", "3654");
        User user3 = new User("Andrey", "7894");
        Collections.addAll(users, user1, user2, user3);
        return users;
    }

    public static void startAuthorizationMenu(ArrayList<User> users) {
        AuthorizationUser( users);
    }

    private static void AuthorizationUser( ArrayList<User> users) {
        boolean isAction = true;
        while (isAction) {
            System.out.println(AuthorizationMenu);
            switch (Helper.readInt()) {
                case 1:
                    login(users);
                    break;
                case 2:
                    registration(users);
                    break;
                case 0:
                    isAction = false;
//                    System.out.println(Menu.getCatalogMenu());;
                    break;
                default:
                    System.out.println("Введено некорректное значение");
                    break;
            }
        }
    }

    public  static void login( ArrayList<User> users){
        User user = new User();
        System.out.println("Введите логин");
        user.setLogin(Helper.readString());
        System.out.println("Введите пароль");
        user.setPassword(Helper.readString());
        for (User u: users) {
            if (u.equals(user) == true) {
                System.out.println("Добро пожаловать в каталог!\n");
                startCatalogMenu(user);
                return;
            }
        }
        System.out.println("введите корректный логин и пароль!");
                login( users);
    }

    static void registration ( ArrayList<User> users) {
        User user  = new User();
        System.out.println("Введите логин");
        user.setLogin(Helper.readString());
        System.out.println("Введите пароль");
        user.setPassword(Helper.readString());
        Collections.addAll(users, user);
        User.saveToFile(users, fileUser);
    }

}
