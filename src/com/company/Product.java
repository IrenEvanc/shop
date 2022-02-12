package com.company;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private double price;
    private double rating;

    public  Product (String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name;
    }
}
