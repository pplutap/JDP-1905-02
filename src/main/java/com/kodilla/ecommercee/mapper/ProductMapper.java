package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(p -> new ProductDto(p.getName(), p.getDescription(),
                        p.getPrice())).collect(Collectors.toList());
    }

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getName(), product.getDescription(), product.getPrice());
    }

    public Product mapToProduct(ProductDto productDto) {
        return new Product(productDto.getName(), productDto.getDescription(), productDto.getPrice());
    }
}
