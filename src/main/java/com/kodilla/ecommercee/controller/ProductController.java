package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "https://glacial-reef-77706.herokuapp.com")
@RestController
@RequestMapping("/superShop")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(){
        return productMapper.mapToProductDtoList(service.getAllProducts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId){
        return productMapper.mapToProductDto((Product) service.getProduct(productId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productMapper.mapToProductDto(service.saveProduct(productMapper.mapToProduct(productDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct", consumes = APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        return productMapper.mapToProductDto(service.saveProduct(productMapper.mapToProduct(productDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        service.deleteProduct(productId);
    }

    public List<ProductDto> createProductFromList(List<ProductDto> productDtoList){
        List<ProductDto> savedList = productDtoList.stream()
                .map(p -> createProduct(p))
                .collect(Collectors.toList());
        return savedList;
    }
}
