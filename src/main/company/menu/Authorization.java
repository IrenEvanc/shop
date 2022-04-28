//package com.company.menu;
//
//import main.entity.User;
//import com.company.helper.Helper;
//import com.company.helper.Loading;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//import static com.company.Main.fileUser;
//
//public class Authorization {
//
//    private static String AuthorizationMenu = "Выберете действие:\n" +
//            "1 - Войти в систему\n" +
//            "2 - Зарегистрироваться\n" +
//            "0 - Вернуться в главное меню";
//
//
////    public static User startAuthorizationMenu(ArrayList<User> users) {
////        User user = AuthorizationMenu(users);
////        return user;
////    }
//
////    private static User AuthorizationMenu(ArrayList<User> users) {
////        boolean isAction = true;
////        while (isAction) {
////            System.out.println(AuthorizationMenu);
////            switch (Helper.readInt()) {
////                case 1:
////                    var user = authorize();
////                    if (user != null) {
////                        System.out.println("Добро пожаловать в каталог, " + user.getLogin());
////                        return user;
////                    }
////                    break;
////                case 2:
////                    user = registration(users);
////                    System.out.println("Добро пожаловать в каталог, " + user.getLogin());
////                    return  user;
////                case 0:
////                    isAction = false;
////                    break;
////                default:
////                    System.out.println("Введено некорректное значение");
////                    break;
////            }
////        }
////        return null;
////    }
////
////    private static User authorize() {
////        User user = login();
////        if(user!=null) {var userIsAuthorized = checkPassword(user);
////        return userIsAuthorized ? user : null;}
////        else return null;
////    }
//
////    private static User login() {
////        while (true) {
////            System.out.println("Введите логин (0. Войти без регистрации)");
////            String login = Helper.readString();
////            if (login.equals("0")) {
////                return null;
////            } else {
////                User user = findUserByLogin(login);
////                if (user != null) {
////                    return user;
////                } else {
////                    System.out.println("Неверный логин.\n");
////                }
////            }
////        }
////    }
//
////    private static User findUserByLogin(String login) {
////        for (User user : Loading.getUsers()) {
////            if (user.getLogin().equals(login)) {
////                return user;
////            }
////        }
////        return null;
////    }
//
//    private static boolean checkPassword(User user) {
//        var userPassword = user.getPassword();
//        while (true) {
//            System.out.println("Введите пароль --> ");
//            String password = Helper.readString();
//            if (password.equals(userPassword)) {
//                return true;
//            } else {
//                System.out.println("Неверный пароль.\n");
//            }
//        }
//    }
////
////    static User registration(ArrayList<User> users) {
////        User user  = new User();
////        System.out.println("Введите логин");
////        user.setLogin(Helper.readString());
////        System.out.println("Введите пароль");
////        String password = Helper.readString();
////        while (true) {
////            System.out.println("Введите пароль повторно");
////            if (password.equals(Helper.readString())) {
////                user.setPassword(password);
////                Collections.addAll(users, user);
////                User.saveToFile(users, fileUser);
////               return user;
////            } else {
////                System.out.println("Неверно!");
////            }
////        }
////
////    }
//
//}
