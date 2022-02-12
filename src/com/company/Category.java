package com.company;

import com.company.helper.Helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Category implements Serializable {
    private  String name;
    private ArrayList<Product> products;

    public Category (String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void categoryIncludes(int number) {
        System.out.println("Категория " + this.name + " включает " + number + " товаров.");
    }

        public static  void categoryIncludes(Category category, ArrayList<Product> products) {
        System.out.println("Категория "+ category.name + " включает следующие товары:\n");
            int i=1;
            System.out.println("№ " + " Наименование товара " + "Стоимость" );
            for (Product product: products){
                System.out.println(i+". "+ "       " + product.getName() + "       " + " " +product.getPrice() + "\n");
                i++;
            }
        System.out.println();
    }

    public static ArrayList<Product>  input () {
        ArrayList<Product> products = new ArrayList<>();
        boolean flag = true;
        double x, y;
        while (flag ){
            if (products.size()<1){
                products.add(getProduct());
            }
            else {
                System.out.println("Добавить товар в категорию Y/N");
                switch (Helper.readString()) {
                    case "Y":
                        products.add(getProduct());
                        break;
                    case "N":
                        flag = false;
                        break;
                    default:
                        System.out.println("Введено некорректное значение");
                        break;
                }
            }
        }
        return products;
    }
    private static Product getProduct() {
        System.out.println("Введите название товара");
        String name = Helper.readString();
        System.out.println("Введите стоимость товара");
        double price = Helper.readDouble();
        System.out.println("Введите рейтинг товара");
        double rating = Helper.readDouble();
        return new Product(name,price, rating);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }


    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
