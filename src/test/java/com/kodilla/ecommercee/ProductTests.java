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

        //Then
        Long id = product.getId();
        Product foundProduct = (Product) genericEntityRepository.getOne(id);
        Assert.assertNotEquals(null, foundProduct);

        //CleanUp
        genericEntityRepository.deleteById(id);

    }

    @Test
    public void testUpdateProduct() {

        //Given
        Product product = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90);
        genericEntityRepository.save(product);

        //When
        Long id = product.getId();
        Product productToUpdate = (Product) genericEntityRepository.getOne(id);
        productToUpdate.setPrice(1000.73);
        genericEntityRepository.save(productToUpdate);

        //Then
        productToUpdate = (Product) genericEntityRepository.getOne(id);
        double updatedPrice = productToUpdate.getPrice();
        Assert.assertEquals(1000.73, updatedPrice, 0.00);

        //CleanUp
        genericEntityRepository.deleteById(id);

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
        genericEntityRepository.delete(product1);
        long productCounter = genericEntityRepository.count();


        //Then
        Assert.assertEquals(2L, productCounter);

        //CleanUp
        genericEntityRepository.delete(product2);
        genericEntityRepository.delete(product3);
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

        //CleanUp
        genericEntityRepository.deleteById(id);
    }

    @Test
    public void getProducts() {

        //Given
        Product product1 = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90);
        Product product2 = new Product("Krzesło Romea", "Krzesło składane z drewna ...", 66.90);
        Product product3 = new Product("Wkrętarka udarowa", "Wkrętarka marki Hilti ...", 3980.90);
        genericEntityRepository.save(product1);
        genericEntityRepository.save(product2);
        genericEntityRepository.save(product3);

        //When
        int productCounter = genericEntityRepository.findAll().size();

        //Then
        Assert.assertEquals(3, productCounter);

        //CleanUp
        genericEntityRepository.delete(product1);
        genericEntityRepository.delete(product2);
        genericEntityRepository.delete(product3);
    }

}
