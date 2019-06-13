package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Product extends GenericEntity {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name="PRODUCT_ID", unique = true)
    private Long id;
    private String name;
    private String description;
    private double price;

    @ManyToMany(cascade = CascadeType.PERSIST,
            mappedBy = "products")
    private List<Cart> carts;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    public Product(){}

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Group getGroup() {
        return group;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
