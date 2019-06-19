package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TABLE_OF_ORDERS")
public class Order {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Cart.class,
            mappedBy = "order")
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    public Order(){}

    public Order(User user, Cart cart) {
        this.user = user;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

}
