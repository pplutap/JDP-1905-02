package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class User {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID" ,unique = true)
    private Long id;
    private String username;
    private boolean status;
    private Long userKey;

    @OneToMany(targetEntity = Order.class, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public User(){}

    public User(String username, Long userKey) {
        this.username = username;
        this.userKey = userKey;
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getUserKey() {
        return userKey;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
