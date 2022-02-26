package com.company;

import java.io.*;
import java.util.ArrayList;

public class Basket implements  Serializable {
    //Да и как будто рано их ещё называть приобретёнными, он же их ещё не купил, только в корзину положил
    //а ещё большую путанницу это внесёт, когда будем смотреть историю заказов, то есть на самом деле приобретённые товары
    private ArrayList<Product> purchasedProducts;

     public Basket() {
        this.purchasedProducts = new ArrayList<>();
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    //Пут продактС подразумевает что я их сюда много класть буду, а можно только один - нестыковочка
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