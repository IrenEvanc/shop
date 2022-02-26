package com.company;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private double price;
    private double rating;
    //кто такой этот намбер?0_0 откуда он тут взялся? 0_0 с чего бы товару кофе знать сколько его взяли ? 0_0
    private int number;

    public  Product (String name, double price, double rating, int number) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.number = number;
    }

    public Product () {}

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }


}
