package company.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Basket")
public class Basket implements  Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @OneToOne(optional = false, mappedBy="basket")
    private User user;

    @OneToMany(mappedBy = "basket", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Product> products;

    @Lob @Type(type = "org.hibernate.type.DoubleType")
    @Column(name = "number")
    private Number number;

//    private HashMap<Product, Number> productsInBasket;

    public Basket() {

//        this.productsInBasket = new HashMap<>();
    }

//
//    public void putProduct(Product product, Number number) {
//        this.productsInBasket.put(product,number);
//    }
//

//    public HashMap<Product, Number> getProductsInBasket() {
//        return productsInBasket;
//    }
//
//    @Override
//    public String toString() {
//        return "Basket{" +
//                "productsInBasket=" + productsInBasket +
//                '}';
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public void setNumber(Number number) {
        this.number = number;
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