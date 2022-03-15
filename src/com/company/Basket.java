package com.company;

import java.io.*;
import java.util.HashMap;

public class Basket implements  Serializable {
    //Да и как будто рано их ещё называть приобретёнными, он же их ещё не купил, только в корзину положил
    //а ещё большую путанницу это внесёт, когда будем смотреть историю заказов, то есть на самом деле приобретённые товары
    private HashMap<Product, Number> productsInBasket;

     public Basket() {
        this.productsInBasket = new HashMap<>();
    }


    //Пут продактС подразумевает что я их сюда много класть буду, а можно только один - нестыковочка
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