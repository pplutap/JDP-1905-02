package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartProductAdderDto;
import com.kodilla.ecommercee.domain.CartProductDeleterDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins =  "https://glacial-reef-77706.herokuapp.com")
@RestController
@RequestMapping("/superShop")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;


    @RequestMapping(method = RequestMethod.POST, value = "createEmptyCart")
    public Long createEmptyCart(){
        return cartService.createNewCart();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductsFromTheCart")
    public List<ProductDto> getProductsFromTheCart(@RequestParam Long cartId){
        return productMapper.mapToProductDtoList(cartService.getProductsFromTheCart(cartId));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addProductsToTheCartSelectedById", consumes = APPLICATION_JSON_VALUE)
    public List<ProductDto> addProductsToTheCartSelectedById(@RequestBody CartProductAdderDto cartProductAdderDto){
        return productMapper.mapToProductDtoList(cartService.addProductsToCart(cartMapper.mapToIdFromCartAdderDto(cartProductAdderDto)
                , cartMapper.mapToProductsListFromCartAdderDto(cartProductAdderDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductByIdInGivenCardById", consumes = APPLICATION_JSON_VALUE)
    public void deleteProductByIdInGivenCardById(@RequestBody CartProductDeleterDto cartProductDeleterDto){
        cartService.deleteProductByIdInGivenCardById(cartProductDeleterDto.getId(), cartProductDeleterDto.getProductId());
    }

    @RequestMapping(method = RequestMethod.POST, value = "placeOrderByCartId")
    public Long placeOrderByCartId(@RequestParam Long userId, @RequestParam Long cartId){
        return cartService.createNewOrder(userId, cartId);
    }
}
