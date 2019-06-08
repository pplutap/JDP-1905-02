package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name= "CART_ID", unique = true)
    private Long cartId;


    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "ORDER_ID")
    //private Order order;

    //@ManyToMany(cascade = CascadeType.ALL)
    //@JoinTable(
      //      name = "JOIN_PRODUCT_CART",
        //    joinColumns = {@JoinColumn(name = "CART_ID",referencedColumnName = "CART_ID" )},
          //  inverseJoinColumns = {@JoinColumn(name ="PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
    //)
    //private List<Product> products;

    public Cart() {
    }

    public Cart(List<Product> products) {
        //this.products = new ArrayList<>();
    }

    public Long getCartId() {
        return cartId;
    }

    //public Order getOrder() {
        //return order;
    //}

    //public List<Product> getProducts() {
        //return products;
    //}

}
