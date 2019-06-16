package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.service.TokenService;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID" ,unique = true)
    private Long id;
    private String username;
    private String status;
    private Long userKey;

    @OneToMany(targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public User(){}

    public User(String username) {
        this.username = username;
        TokenService tokenService = new TokenService();
        this.userKey=tokenService.generateRandomKey();
        this.status = "UNBLOCKED";
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserKey() {
        return userKey;
    }
}
