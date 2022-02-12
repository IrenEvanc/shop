package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable{
    private String login;
    private String password;
    private Basket basket;
    static int count = 0;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.basket = new Basket();
        count++;
        }

    public User () {
        this.basket = new Basket();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public Basket getBasket() {
        return basket;
    }
//    public String getPassword() {
//        return password.charAt(0) + "*****";
//    }
    public String getPassword() {return password;}
    public void setPassword(String password) {
        this.password = password;
    }

    public void putProductsInBasket(Product product) {
        this.basket.putProducts(product);
    }

    public static ArrayList<User> initFromFile(String file){
        ArrayList<User> users = new ArrayList<User>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            users = (ArrayList<User>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    public static void saveToFile(ArrayList<User> users, String file){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false));
            oos.writeObject(users);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", basket=" + basket +
                '}';
    }
}
//    public void takeBasket(int number) {
//        System.out.println(this.login + " взял " + number + " товаров.");
//    }