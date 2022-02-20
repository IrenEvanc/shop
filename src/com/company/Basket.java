package com.company;

import java.io.*;
import java.util.ArrayList;

public class Basket implements  Serializable {
    private ArrayList<Product> purchasedProducts;

     public Basket() {
        this.purchasedProducts = new ArrayList<>();
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void putProducts(Product product) {
        this.purchasedProducts.add(product);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "purchasedProducts=" + purchasedProducts +
                '}';
    }
}




//    private Product product;
//    private int number;
//
//    public Basket(Product product, int number) {
//        this.product = product;
//        this.number = number;
//    }
//
//    public  Basket (){}
//    public ArrayList<Product> getPurchasedProducts() {
//        return purchasedProducts;
//    }
//
//    public void putProducts(Product product, int number) {
//        Basket basket =new Basket();
//        basket(product, number);
//    }