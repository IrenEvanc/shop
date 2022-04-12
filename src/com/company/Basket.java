package com.company;

import java.io.*;
import java.util.HashMap;

public class Basket implements  Serializable {

    private HashMap<Product, Number> productsInBasket;

     public Basket() {
        this.productsInBasket = new HashMap<>();
    }


    public void putProduct(Product product, Number number) {
        this.productsInBasket.put(product,number);
    }

    public HashMap<Product, Number> getProductsInBasket() {
        return productsInBasket;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "productsInBasket=" + productsInBasket +
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
//    public void putProduct(Product product, int number) {
//        Basket basket =new Basket();
//        basket(product, number);
//    }