package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TABLE_OF_GROUPS")
public class Group  {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID" ,unique = true)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Product.class, mappedBy = "group",
            cascade = CascadeType.ALL,fetch=FetchType.LAZY)
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
