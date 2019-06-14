package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart extends GenericEntity {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name= "CART_ID", unique = true)
    private Long cartId;

    @OneToOne(cascade = CascadeType.ALL)
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
        this.products = new ArrayList<>();
    }

    public Long getCartId() {
        return cartId;
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
