package com.company.menu;

import com.company.Category;
import com.company.User;
import com.company.helper.Helper;
import com.company.helper.Loading;

import java.util.ArrayList;
import java.util.Collections;

import static com.company.Main.fileUser;

public class Authorization {

    private static String AuthorizationMenu = "Выберете действие:\n" +
            "1 - Войти в систему\n" +
            "2 - Зарегистрироваться\n" +
            "0 - Вернуться в главное меню";


    public static void startAuthorizationMenu(ArrayList<User> users, ArrayList<Category> categories) {
        AuthorizationUser(users, categories);
    }

    private static void AuthorizationUser(ArrayList<User> users, ArrayList<Category> categories) {
        boolean isAction = true;
        while (isAction) {
            System.out.println(AuthorizationMenu);
            switch (Helper.readInt()) {
                case 1:
                    var user = authorize();
                    if (user != null) {
                        System.out.println("Добро пожаловать в каталог");
                        Catalog.startCatalogMenu(user, categories);
                    } else {
                        Catalog.startCatalogMenu(categories);
                    }
                    break;
                case 2:
                    registration(users);
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

    private static User authorize() {
        User user = login();
        var userIsAuthorized = checkPassword(user);
        return userIsAuthorized ? user : null;
    }

    private static User login() {
        while (true) {
            System.out.println("Введите логин");
            String login = Helper.readString();
            User user = findUserByLogin(login);
            if (user != null) {
                return user;
            } else {
                System.out.println("Неверный логин.\n");

            }
        }
    }


    private static User findUserByLogin(String login) {
        for (User user : Loading.getUsers()) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        System.out.println("\nНеверный логин!\n");
        return null;
    }

    private static boolean checkPassword(User user) {
        var userPassword = user.getPassword();
        while (true) {
            System.out.println("Введите пароль --> ");
            String password = Helper.readString();
            if (password.equals(userPassword)) {
                return true;
            } else {
                System.out.println("Неверный пароль.\n");

            }
        }
    }

    static void registration(ArrayList<User> users) {

        User user  = new User();
        System.out.println("Введите логин");
        user.setLogin(Helper.readString());
        System.out.println("Введите пароль");
        user.setPassword(Helper.readString());
        Collections.addAll(users, user);
        User.saveToFile(users, fileUser);

    }
}
