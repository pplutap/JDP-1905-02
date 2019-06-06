package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private Long id;
    private String userName;
    private boolean isActive;
    private String generatedKey;
    private List<OrderDto> orders = new ArrayList<>();

    public UserDto(Long id, String userName, boolean isActive, String generatedKey) {
        this.id = id;
        this.userName = userName;
        this.isActive = isActive;
        this.generatedKey = generatedKey;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getGeneratedKey() {
        return generatedKey;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }
}
