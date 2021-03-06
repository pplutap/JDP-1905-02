package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTests {

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void testSaveProduct() {

        //Given
        Group group = new Group("test group");
        Product product = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90, group);
        //When
        productRepository.save(product);
        Long id = product.getId();
        Product foundProduct = productRepository.getOne(id);

        //Then
        Assert.assertNotEquals(null, foundProduct);

    }

    @Test
    public void testUpdateProduct() {

        //Given
        Group group = new Group("test group");
        Product product = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90, group);
        productRepository.save(product);
        Long id = product.getId();
        Product productToUpdate = productRepository.getOne(id);

        //When
        productToUpdate.setPrice(1000.73);
        productRepository.save(productToUpdate);

        productToUpdate = productRepository.getOne(id);
        double updatedPrice = productToUpdate.getPrice();

        //Then
        Assert.assertEquals(1000.73, updatedPrice, 0.00);

    }

    @Test
    public void deleteProduct() {

        //Given
        Group group = new Group("test group");
        Product product1 = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90, group);
        Product product2 = new Product("Krzesło Romea", "Krzesło składane z drewna ...", 66.90, group);
        Product product3 = new Product("Wkrętarka udarowa", "Wkrętarka marki Hilti ...", 3980.90, group);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //When
        long productCounterBeforeDeletion = productRepository.count();
        productRepository.delete(product1);
        long productCounter = productRepository.count();


        //Then
        Assert.assertEquals(productCounterBeforeDeletion-1, productCounter);
    }

    @Test
    public void getProduct() {

        //Given
        Group group = new Group("test group");
        Product product = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90, group);
        productRepository.save(product);

        //When
        Long id = product.getId();
        Product foundProduct = productRepository.getOne(id);
        String productName = foundProduct.getName();
        String productDescription = foundProduct.getDescription();
        double productPrice = foundProduct.getPrice();

        //Then
        Assert.assertEquals("Altana ogrodowa ...", productDescription);
        Assert.assertEquals("Altana SunSet", productName);
        Assert.assertEquals(999.90, productPrice, 0.00);

    }

    @Test
    public void getProducts() {

        //Given
        Group group = new Group("test group");
        Product product1 = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90, group);
        Product product2 = new Product("Krzesło Romea", "Krzesło składane z drewna ...", 66.90, group);
        Product product3 = new Product("Wkrętarka udarowa", "Wkrętarka marki Hilti ...", 3980.90, group);
        int productCounterBeforeSave = productRepository.findAll().size();
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //When
        int productCounter = productRepository.findAll().size();

        //Then
        Assert.assertEquals(productCounterBeforeSave + 3, productCounter);

    }

}
