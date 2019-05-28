package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/superShop")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(){
        return new ArrayList<>(Arrays.asList(new ProductDto(1L,"SuperButter", "Super Fat Butter.", 3.99),
                new ProductDto(2L, "Mega Meal", "Epic meal moment.",8.99)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return new ProductDto(1L, "Test product", "Test description",5.99);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(ProductDto productDto){

    }

    public ProductDto updateProduct(ProductDto productDto){
        return new ProductDto(1L, "Edited test title", "Edited or not test description.",0.99);
    }

    public void deleteProduct(Long productId){

    }
}
