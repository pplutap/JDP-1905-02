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
    private Long id;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Order.class,
            mappedBy = "cart")
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(
            name = "JOIN_PRODUCT_CART",
            joinColumns = {@JoinColumn(name = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name ="PRODUCT_ID")}
    )
    private List<Product> products;
    private LocalDate cartUpdate;

    public Cart() {
    }

    public Cart(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getUpdates() {
        return cartUpdate;
    }
}
