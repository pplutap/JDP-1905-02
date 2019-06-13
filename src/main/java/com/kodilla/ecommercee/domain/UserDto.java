package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private Long id;
    private String username;
    private String status;
    private Long userKey;

    @JsonIgnore
    private List<OrderDto> orders = new ArrayList<>();

    public UserDto(Long id, String username, String status, Long userKey) {
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

    public Long getUserKey() {
        return userKey;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }
}
