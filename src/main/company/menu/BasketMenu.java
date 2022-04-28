//package com.company.menu;
//
//import com.company.*;
//import main.entity.Check;
//import main.entity.User;
//import com.company.helper.Helper;
//import com.company.helper.Loading;
//
//import java.util.*;
//
//import static com.company.Main.fileUser;
//
//public class BasketMenu {
//
//    private static String BasketMenu =
//            "1 - Редактировать корзину\n" + // изменить количество и удалить
//                    "2 - Купить все\n" +
//                    "3 - Показать чеки покупок\n" +
//                    "0 - Вернуться в каталог";
//    private static String EditBasketMenu =
//            "1 - Изменить количество\n" +
//                    "2 - Удалить товар\n" +
//                    "0 - Вернуться в каталог";
//
////    public static void goBasketMenu(User user, ArrayList<Category> categories) {
////        BasketMenu(Loading.getUsers(), user, categories);
////    }
//
//    private static void BasketMenu(ArrayList<User> users, User user,ArrayList<Category> categories) {
//        boolean isAction = true;
//        System.out.println("");
//        while (isAction) {
//            System.out.println(BasketMenu);
//            switch (Helper.readInt()) {
//                case 1:
//                    editBasket(user, users, categories);
//                    break;
////                case 2:
////                    buyAllProducts(user, users);
////                    break;
////                case 3:
////                    showPurchaseReceipts(user);
////                    break;
//                case 0:
//                    isAction = false;
//                    break;
//                default:
//                    System.out.println("Введено некорректное значение");
//                    break;
//            }
//        }
//    }
//
//    public static void editBasket(User user, ArrayList<User> users, ArrayList<Category> categories) {
//        boolean isAction = true;
//        System.out.println("");
//        showBasket(user, categories);
//        while (isAction) {
//            System.out.println(EditBasketMenu);
//            switch (Helper.readInt()) {
////                case 1:
////                    changeNumberOfProduct(user, users);
////                    break;
////                case 2:
////                    deleteProductFromBasket(user, users);
////                    break;
//                case 0:
//                    isAction = false;
//                    break;
//                default:
//                    System.out.println("Введено некорректное значение");
//                    break;
//            }
//        }
//    }
////
////    public static void selectProduct(User user, ArrayList<Category> categories, ArrayList<Product> products, ArrayList<User> users) {
////        users.remove(user);
////        System.out.println("Введите номер продукта");
////        int i = Helper.readInt(0, products.size() + 1);
////        Product product = products.get(i - 1);
////        System.out.println("Введите желаемое количество товара");
////        Number number = Helper.readInt();
////        user.putProductInBasket(product, number);
////        System.out.println("Наименование выбранного товара: " + product.getName() + "   Цена:" + product.getPrice() + "   Количество:" + number);
////        System.out.println("Хотите выбрать еще товар?");
////        switch (Helper.readString()) {
////            case "Y":
////                Catalog.showCategories(categories);
////                break;
////            case "N":
////                Catalog.startCatalogMenu(user, categories);
////                break;
////        }
////        Collections.addAll(users, user);
////        User.saveToFile(users, fileUser);
////    }
//
//    public static void showBasket(User user, ArrayList<Category> categories) {
//        Basket basket = user.getBasket();
//        HashMap<Product, Number> products = basket.getProductsInBasket();
//        if (products.isEmpty()) {
//            System.out.println("Корзина пуста!\n Хотите вернуться в каталог?");
//            switch (Helper.readString()) {
//                case "Y":
//                    Catalog.startCatalogMenu(user, categories);
//                    break;
//                case "N":
//                    System.exit(0);
//            }
//
//        } else {
//            System.out.println("Корзина\n");
//            displayingTableWithProducts(products);
//        }
//    }
//
//    private  static void displayingTableWithProducts ( HashMap<Product, Number> products) {
//
//        int i = 1;
//        int sum = 0;
//        System.out.format("\t %1$-5s %2$-30s  %3$-10s  %4$-10s\n", "№ ", " Наименование товара ", "Стоимость", "Количество");
//        for (Map.Entry<Product, Number> product : products.entrySet()) {
//            System.out.format("\t %1$-5s %2$-30s  %3$-10s  %4$-10s\n", i + ". ", product.getKey().getName(), product.getKey().getPrice(), product.getValue());
//            i++;
//            sum = sum + ((int) product.getKey().getPrice() * (int) product.getValue());
//        }
//        System.out.format("\t %1$-45s %2$-10s\n", "Общая стоимость товара", sum);
//        System.out.println();
//
//    }
//
//    private static Product selectProduct(User user) {
//        HashMap<Product, Number> products = user.getBasket().getProductsInBasket();
//        Set<Product> products1 = products.keySet();
//        System.out.println("\nВведите номер товара, который желаете изменить/удалить");
//        Product product = (Product) products1.toArray()[Helper.readInt()-1];
//        return product;
//    }
//
////    private static void changeNumberOfProduct (User user, ArrayList<User> users){
////        Product product = selectProduct(user);
////        HashMap<Product, Number> products = user.getBasket().getProductsInBasket();
////        System.out.println("Введите желаемое количество товара");
////        products.replace (product, Helper.readInt());
////        users.remove(user);
////        Collections.addAll(users, user);
////        User.saveToFile(users, fileUser);
////    }
////
////    private static void deleteProductFromBasket (User user, ArrayList<User> users){
////        Product product = selectProduct(user);
////        HashMap<Product, Number> products = user.getBasket().getProductsInBasket();
////        products.remove(product);
////        users.remove(user);
////        Collections.addAll(users, user);
////        User.saveToFile(users, fileUser);
////    }
//
////    private static void buyAllProducts(User user, ArrayList<User> users) {
////        HashMap<Product, Number> purchasedProducts = user.getBasket().getProductsInBasket();
////
////        Check check = new Check(Check.addPurchasedProducts(purchasedProducts));
////        user.purchaseReceipts(check);
////
////        user.clearBasket();
////        User.saveToFile(users, fileUser);
////    }
//    private static ArrayList<Check> allUserChecks(User user) {
//        return user.getChecks();
//    }
////    private static void showPurchaseReceipts(User user) {
////        ArrayList<Check> checks = allUserChecks(user);
////
////        for (Check check: checks) {
////
////            System.out.println();
////            System.out.println("Чек\n " + "Дата покупки:" +  check.getDate() +"\n");
////            HashMap<Product, Number> products = check.getPurchasedProducts();
////            displayingTableWithProducts(products);
////
////        }
////        System.out.println();
////
////    }
//}
