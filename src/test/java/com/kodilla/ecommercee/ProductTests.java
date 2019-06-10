package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Product;
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
    private GenericEntityRepository genericEntityRepository;


    @Test
    public void testSaveProduct() {

        //Given
        Product product = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90);

        //When
        genericEntityRepository.save(product);
        Long id = product.getId();
        Product foundProduct = (Product) genericEntityRepository.getOne(id);

        //Then
        Assert.assertNotEquals(null, foundProduct);

    }

    @Test
    public void testUpdateProduct() {

        //Given
        Product product = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90);
        genericEntityRepository.save(product);
        Long id = product.getId();
        Product productToUpdate = (Product) genericEntityRepository.getOne(id);

        //When
        productToUpdate.setPrice(1000.73);
        genericEntityRepository.save(productToUpdate);

        productToUpdate = (Product) genericEntityRepository.getOne(id);
        double updatedPrice = productToUpdate.getPrice();

        //Then
        Assert.assertEquals(1000.73, updatedPrice, 0.00);

    }

    @Test
    public void deleteProduct() {

        //Given
        Product product1 = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90);
        Product product2 = new Product("Krzesło Romea", "Krzesło składane z drewna ...", 66.90);
        Product product3 = new Product("Wkrętarka udarowa", "Wkrętarka marki Hilti ...", 3980.90);
        genericEntityRepository.save(product1);
        genericEntityRepository.save(product2);
        genericEntityRepository.save(product3);

        //When
        long productCounterBeforeDeletion = genericEntityRepository.count();
        genericEntityRepository.delete(product1);
        long productCounter = genericEntityRepository.count();


        //Then
        Assert.assertEquals(productCounterBeforeDeletion-1, productCounter);
    }

    @Test
    public void getProduct() {

        //Given
        Product product = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90);
        genericEntityRepository.save(product);

        //When
        Long id = product.getId();
        Product foundProduct = (Product) genericEntityRepository.getOne(id);
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
        Product product1 = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90);
        Product product2 = new Product("Krzesło Romea", "Krzesło składane z drewna ...", 66.90);
        Product product3 = new Product("Wkrętarka udarowa", "Wkrętarka marki Hilti ...", 3980.90);
        int productCounterBeforeSave = genericEntityRepository.findAll().size();
        genericEntityRepository.save(product1);
        genericEntityRepository.save(product2);
        genericEntityRepository.save(product3);

        //When
        int productCounter = genericEntityRepository.findAll().size();

        //Then
        Assert.assertEquals(productCounterBeforeSave + 3, productCounter);

    }

}
