package company.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "name")
    private String name;

    @Lob @Type(type = "org.hibernate.type.DoubleType")
    @Column(name = "price")
    private double price;

    @Lob @Type(type = "org.hibernate.type.DoubleType")
    @Column(name = "rating")
    private double rating;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "basket_id", nullable = false)
    private Basket basket;

//    public  Product (String name, double price, double rating) {
//        this.name = name;
//        this.price = price;
//        this.rating = rating;
//    }

    public Product () {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }
    public double getRating() {
        return rating;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "name='" + name + '\'' +
//                ", price=" + price +
//                ", rating=" + rating +
//                '}';
//    }
}
