package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private Long id;
    private String username;
    private String status;
    private String userKey;

    @JsonIgnore
    private List<OrderDto> orders = new ArrayList<>();

    public UserDto(Long id, String username, String status, String userKey) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }

    public String getUserKey() {
        return userKey;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }
}
