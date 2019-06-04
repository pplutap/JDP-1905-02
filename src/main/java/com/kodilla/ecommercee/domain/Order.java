package com.kodilla.ecommercee.domain;

import org.apache.catalina.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class Order {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "USER_ID")
    private User user;

    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "CART_ID")
    //private Cart cart;
    private List<LocalDate> updates;

    public Order(){}

    public Order(Long id, User user, /*Cart cart,*/ List<LocalDate> updates) {
        this.id = id;
        this.user = user;
        //this.cart = cart;
        this.updates = updates;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    //public Cart getCart() {
      //  return cart;
    //}

    public List<LocalDate> getUpdates() {
        return updates;
    }
}
