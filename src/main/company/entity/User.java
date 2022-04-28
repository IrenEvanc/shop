package company.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Users")
public class User implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "login")
    private String login;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "password")
    private String password;

    @OneToOne(optional = false, cascade = CascadeType.REFRESH, fetch=FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Check> checks = new ArrayList<Check>();


    public User() {
//        this.login = new String();
//        this.password = new String();
//        this.basket = new Basket();
//        this.checks = new ArrayList<>();

        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }

//
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//    public Basket getBasket() {
//        return basket;
//    }
//
//    public String getPassword() {return password;}
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void putProductInBasket(Product product, Number number) {
//        this.basket.putProduct(product, number);
//    }
//
//    public void purchaseReceipts(Check check) {
//        this.checks.add(check);
//    }
//
//    public ArrayList<Check> getChecks() {
//        return checks;
//    }
//
//
//    public static ArrayList<User> initFromFile(String file){
//        ArrayList<User> users = new ArrayList<User>();
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//            users = (ArrayList<User>) ois.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//    public static void saveToFile(ArrayList<User> users, String file){
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false));
//            oos.writeObject(users);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(login, password);
//    }
//
//
//
//    public Basket clearBasket() {
//        this.basket.getProductsInBasket().clear();
//        return basket;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                ", basket=" + basket +
//                ", checks=" + checks +
//                '}';
//    }

}
