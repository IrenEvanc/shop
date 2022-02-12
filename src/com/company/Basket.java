package com.company;

import java.io.*;
import java.util.ArrayList;

public class Basket implements  Serializable{
    private ArrayList<Product> purchasedProducts;

    public Basket() {
        this.purchasedProducts = new ArrayList<Product>();
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
