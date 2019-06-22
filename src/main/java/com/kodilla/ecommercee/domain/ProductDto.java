package com.kodilla.ecommercee.domain;

import com.opencsv.bean.CsvBindByPosition;

public class ProductDto {

    private  Long id;
    @CsvBindByPosition(position = 0, required = true)
    private String name;
    @CsvBindByPosition(position = 1, required = true)
    private String description;
    @CsvBindByPosition(position = 2, required = true)
    private double price;
    @CsvBindByPosition(position = 3, required = true)
    private String groupId;

    public ProductDto() {}

    public ProductDto(String name, String description, double price, String groupId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDto that = (ProductDto) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (!name.equals(that.name)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + description.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
