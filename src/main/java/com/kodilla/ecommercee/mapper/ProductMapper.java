package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ProductMapper {
    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getDescription(),
                        p.getPrice(), p.getGroup().getId())).collect(Collectors.toList());
    }

    public ProductDto mapToProductDto()
}
