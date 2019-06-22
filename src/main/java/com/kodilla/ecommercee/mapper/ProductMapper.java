package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        List<ProductDto> productsDto = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto(product.getName(), product.getDescription()
                    , product.getPrice(), String.valueOf(product.getGroup().getId()));
            productDto.setId(product.getId());
            productsDto.add(productDto);
        }
        return productsDto;
    }

    public ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto(product.getName(), product.getDescription()
                , product.getPrice(), String.valueOf(product.getGroup().getId()));
        productDto.setId(product.getId());
        return productDto;
    }

    public Product mapToProduct(ProductDto productDto) {
        if(productDto.getId() != null){
            return productRepository.getOne(productDto.getId());
        } else {
            return new Product(productDto.getName(), productDto.getDescription()
                    , productDto.getPrice(), groupRepository.getOne(Long.valueOf(productDto.getGroupId())));
        }

    }

    public List<Product> mapToProductList(final List<ProductDto> productsDto) {
        return productsDto.stream()
                .map(p -> productRepository.findById(p.getId()).get())
                .collect(Collectors.toList());
    }
}
