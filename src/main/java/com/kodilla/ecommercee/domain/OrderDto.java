package com.kodilla.ecommercee.domain;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {
    private Long Id;
    private LocalDate created;
    private boolean paid;
    private boolean realised;
    private List<ProductDto> products;

    public OrderDto(Long id, int yearOfOrder, int monthOfOrder, int dayOfOrder, boolean paid, boolean realised, List<ProductDto> products) {
        Id = id;
        this.created = LocalDate.of(yearOfOrder, monthOfOrder, dayOfOrder);
        this.paid = paid;
        this.realised = realised;
        this.products = products;
    }

    public OrderDto() {
    }

    public Long getId() {
        return Id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isRealised() {
        return realised;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
