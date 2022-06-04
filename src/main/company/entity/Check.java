package company.entity;

import company.entity.User.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Chek")
public class Check implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    private HashMap<Product, Number> purchasedProducts;

    public Check() {
//        this.date = new Date();
//        this.purchasedProducts = purchasedProducts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public static HashMap<Product, Number> addPurchasedProducts(HashMap<Product, Number> purchasedProducts) {
//        HashMap<Product, Number> purchasedProducts1 = new HashMap<>();
//        for (Map.Entry<Product, Number> product : purchasedProducts.entrySet()) {
//            int i = 1;
//            int sum = 0;
//            purchasedProducts1.put(product.getKey(), product.getValue());
//            i++;
//            sum = sum + ((int) product.getKey().getPrice() * (int) product.getValue());
//        }
//        return purchasedProducts1;
//    }
//
//    public HashMap<Product, Number> getPurchasedProducts() {
//        return purchasedProducts;
//    }
//
//    @Override
//    public String toString() {
//        return "\n Чек \n" +
//                "Дата " + date +
//                "\n Список продуктов " + getPurchasedProducts() +
//                '}';
//    }

//    public void purchasedProducts(User user) {
//        Basket basket = user.getBasket();
//        this.purchasedProducts = basket.getProductsInBasket();
//    }
}
