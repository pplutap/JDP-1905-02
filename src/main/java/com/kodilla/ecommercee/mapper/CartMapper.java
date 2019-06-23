package com.kodilla.ecommercee.mapper;


import com.kodilla.ecommercee.domain.CartProductAdderDto;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartMapper {

    @Autowired
    private ProductMapper productMapper;

    public Long mapToIdFromCartAdderDto(CartProductAdderDto cartProductAdderDto){
        return cartProductAdderDto.getId();
    }

    public List<Product> mapToProductsListFromCartAdderDto(CartProductAdderDto cartProductAdderDto){
        return productMapper.mapToProductList(cartProductAdderDto.getProductsDto());
    }

}
