package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.ProductNotFoundException;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "https://glacial-reef-77706.herokuapp.com")
@RestController
@RequestMapping("/superShop")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(){
        return new ArrayList<>(Arrays.asList(new ProductDto(1L,"SuperButter", "Super Fat Butter.", 3.99, 1L),
                new ProductDto(2L, "Mega Meal", "Epic meal moment.",8.99, 1L)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return new ProductDto(1L, "Test product", "Test description",5.99, 2L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto){

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct", consumes = APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        return new ProductDto(1L, "Edited test title", "Edited or not test description.",0.99,2L);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) throws ProductNotFoundException{

    }
}
