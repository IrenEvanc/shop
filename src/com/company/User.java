package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable{
    private String login;
    private String password;
    private Basket basket;
    static int count = 0;

    public User() {
        this.login = new String();
        this.password = new String();
        this.basket = new Basket();
        count++;
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

    public String getPassword() {return password;}
    public void setPassword(String password) {
        this.password = password;
    }

    //опять ты говоришь, что кладёшь много продуктов, а на самом деле то всего один
    public void putProductInBasket(Product product, Number number) {
        this.basket.putProduct(product, number);
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
