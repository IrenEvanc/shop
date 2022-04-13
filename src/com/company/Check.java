package com.company;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Check implements Serializable {
    private Date date;
    private HashMap<Product, Number> purchasedProducts;

    public Check(HashMap<Product, Number> purchasedProducts) {
        this.date = new Date();
        this.purchasedProducts = purchasedProducts;
    }

    public Date getDate() {
        return date;
    }

    public static HashMap<Product, Number> addPurchasedProducts(HashMap<Product, Number> purchasedProducts) {
        HashMap<Product, Number> purchasedProducts1 = new HashMap<>();
        for (Map.Entry<Product, Number> product : purchasedProducts.entrySet()) {
            int i = 1;
            int sum = 0;
            purchasedProducts1.put(product.getKey(), product.getValue());
            i++;
            sum = sum + ((int) product.getKey().getPrice() * (int) product.getValue());
        }
        return purchasedProducts1;
    }

    public HashMap<Product, Number> getPurchasedProducts() {
        return purchasedProducts;
    }

    @Override
    public String toString() {
        return "\n Чек \n" +
                "Дата " + date +
                "\n Список продуктов " + getPurchasedProducts() +
                '}';
    }

//    public void purchasedProducts(User user) {
//        Basket basket = user.getBasket();
//        this.purchasedProducts = basket.getProductsInBasket();
//    }
}
