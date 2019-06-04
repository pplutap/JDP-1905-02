package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;
import com.kodilla.ecommercee.domain.CartProductAdderDto;
import com.kodilla.ecommercee.domain.CartProductDeleterDto;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/superShop")
public class CartController {
    private static final ProductDto socks = new ProductDto(3L, "Sport socks", "Most breathable fabric.",9.99, 2L);
    private static final ProductDto tshirt = new ProductDto(4L, "UV T-Shirt", "100% UV protection", 29.99, 2L);

    @RequestMapping(method = RequestMethod.POST, value = "createEmptyCart")
    public void createEmptyCart(){

    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductsFromTheCart")
    public List<ProductDto> getProductsFromTheCart(@RequestParam Long cartId){
        return Arrays.asList(socks,tshirt);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProductsToTheCartSelectedById", consumes = APPLICATION_JSON_VALUE)
    public void addProductsToTheCartSelectedById(@RequestBody CartProductAdderDto cartProductAdderDto){

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductByIdInGivenCardById", consumes = APPLICATION_JSON_VALUE)
    public void deleteProductByIdInGivenCardById(@RequestBody CartProductDeleterDto cartProductDeleterDto){

    }

    @RequestMapping(method = RequestMethod.PUT, value = "placeOrderByCartId")
    public void placeOrderByCartId(@RequestParam Long cartId){

    }
}
