package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Group extends GenericEntity {

    @Id
    @GeneratedValue
    @NotNull
    @Column(unique = true)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Product.class, mappedBy = "group", fetch=FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
