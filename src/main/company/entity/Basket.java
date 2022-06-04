package company.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Table(name = "Basket")
public class Basket implements  Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

//    @OneToOne(optional = false, mappedBy="basket", cascade=CascadeType.ALL)
//    private User user;

//    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "basket_products",
//            joinColumns = @JoinColumn (name = "basket_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private Set<Product> products = new HashSet<>();
//    public void addProduct(Product product){
//        this.products.add(product);
//        product.getBasket().add(this);
//    }
//    public void removeProduct(Product product){
//        this.products.remove(product);
//        product.getBasket().remove(this);
//    }

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable (name = "user_basket",
            joinColumns = @JoinColumn(name = "basket_id"))
    @MapKeyJoinColumn(name = "product_id")

    private Map<Product, Number> productsInBasket = new HashMap<>() ;

    @OneToMany (fetch=FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private List<Check> checks = new ArrayList<>();


//    private HashMap<Product, Number> productsInBasket;

    public Basket() {}

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
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }



    public Map<Product, Number> getProductsInBasket() {
        return productsInBasket;
    }

    public void setProductsInBasket(Map<Product, Number> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
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