package company.entity.Category;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "name")
    private  String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "category_subcategory",
            joinColumns = {@JoinColumn(name = "category_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name = "subcategory_id", referencedColumnName="id")}
    )
    private List<Subcategory> subcategories = new ArrayList<>();
//    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
//    private List<Product> products;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Category (String name, ArrayList<Product> products) {
//        this.name = name;
//        this.products = products;
//    }

    public Category () {}
    public String getName() {
        return name;
    }

//    public List<Product> getProducts() {
//        return products;
//    }


    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
//                ", products=" + products +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

//    public boolean isSelectedSubcategory(Subcategory subcategory){
//        return subcategory.getId().equals(status.getId());
//    }
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }


}

//    public static ArrayList<Product>  addProductToCategory () {
//        ArrayList<Product> products = new ArrayList<>();
//        boolean flag = true;
//        double x, y;
//        while (flag ){
//            if (products.size()<1){
//                products.add(getProduct());
//            }
//            else {
//                System.out.println("Добавить товар в категорию Y/N");
//                switch (Helper.readString()) {
//                    case "Y":
//                        products.add(getProduct());
//                        break;
//                    case "N":
//                        flag = false;
//                        break;
//                    default:
//                        System.out.println("Введено некорректное значение");
//                        break;
//                }
//            }
//        }
//        return products;
//    }
//
//    private static Product getProduct() {
//        System.out.println("Введите название товара");
//        String name = Helper.readString();
//        System.out.println("Введите стоимость товара");
//        double price = Helper.readDouble();
//        System.out.println("Введите рейтинг товара");
//        double rating = Helper.readDouble();
//        return new Product(name,price, rating);
//    }