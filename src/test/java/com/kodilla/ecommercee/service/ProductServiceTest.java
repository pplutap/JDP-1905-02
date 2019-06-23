package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void getAllProductsAndSave()  {
        //Given
        Group group = new Group("test group");
        Product product1 = new Product("product1", "test product1", 9.99, group);
        Product product2 = new Product("product2", "test product2", 9.99, group);

        //When
        productService.saveProduct(product1);
        productService.saveProduct(product2);
        List<Product> requestedProducts = productService.getAllProducts();

        //Then
        assertThat(product1, sameBeanAs(requestedProducts.get(requestedProducts.size()-2)));
        assertThat(product2, sameBeanAs(requestedProducts.get(requestedProducts.size()-1)));

        //Clean Up
        productService.deleteProduct(product1.getId());
        productService.deleteProduct(product2.getId());
    }

    @Test
    public void getProduct() {
        //Given
        Group group = new Group("test group");
        Product product = new Product("product", "test product", 9.99, group);
        productService.saveProduct(product);

        //When
        Product requestedProduct = productService.getProduct(product.getId());

        //Then
        assertThat(product, sameBeanAs(requestedProduct));

        //Clean Up
        productService.deleteProduct(requestedProduct.getId());
    }

    @Test
    public void deleteProduct() {
        //Given
        Group group = new Group("test group");
        Product product = new Product("product", "test product", 9.99, group);
        productService.saveProduct(product);
        Product requestedProduct = productService.getProduct(product.getId());
        long productCounterBeforeDeletion = productRepository.count();

        //When
        productService.deleteProduct(requestedProduct.getId());
        long productCounter = productRepository.count();

        //Then
        Assert.assertEquals(productCounterBeforeDeletion - 1, productCounter);
    }
}