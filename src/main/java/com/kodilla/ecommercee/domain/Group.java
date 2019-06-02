package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(unique = true)
    private Long id;

    @Column
    private String name;

    @JsonIgnore
    //@OneToMany(targetEntity = Product.class, mappedBy = "group", fetch=FetchType.LAZY)
    private List<Product> products;

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

}
