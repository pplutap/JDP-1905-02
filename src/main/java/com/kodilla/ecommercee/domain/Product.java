package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product extends GenericEntity {
    @Id
    @NotNull
    @Column(name="ID", unique = true)
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private double price;

    @ManyToOne(fetch=FetchType.LAZY)
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
}
