package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name="ID", unique = true)
    private Long id;
    private String name;
    private String description;
    private int price;
    //waiting for group entity implementation
    //private Group group;
    //waiting for card entity implementation
    //private List<Cart> carts = new ArrayList<>();

    public Product(){}

    public Product(String name, String description, int price) {
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

    public int getPrice() {
        return price;
    }

    //waiting for group entity implementation
    //public Group getGroup() {
      //  return group;
    //}
    //waiting for card entity implementation
    //public List<Cart> getCarts() {
      //  return carts;
    //}
}
