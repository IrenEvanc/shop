package company.entity;

import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "Users")
public class User implements Serializable, UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "username")
    private String username;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "password")
    private String password;

    @Transient
    private String passwordConfirm;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Check> checks = new ArrayList<Check>();

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "surname")
    private String surname;
    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "name")
    private String name;
    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "fathers_name")
    private String fathersName;
    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "email")
    private String email;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "phone")
    private String phone;

    @Lob @Type(type = "org.hibernate.type.BooleanType")
    @Column(name = "active")
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable (name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated (EnumType.STRING)
    private Set<Role> roles;

    public User() {}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


//
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
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
//        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, password);
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
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", basket=" + basket +
//                ", checks=" + checks +
//                '}';
//    }

}
