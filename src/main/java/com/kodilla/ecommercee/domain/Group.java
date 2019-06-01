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

    @Column
    @JsonIgnore
    private String description;

    @JsonIgnore
    @OneToMany(targetEntity = Product.class, mappedBy = "group", fetch=FetchType.LAZY)
    private List<Product> products;

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Group() {
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

    public List<Product> getProducts() {
        return products;
    }
}
