package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CartCrudTestSuite {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Test
    public void testCartSave() {

        //Given
        Product product1 = new Product("cereals","chocolate",8.99);
        Product product2 = new Product("milk","cow-milk",2.99);
        List<Product> productsFirstCart = new ArrayList<>();
        Cart cartFirst = new Cart(productsFirstCart);
        cartFirst.getProducts().add(product1);
        cartFirst.getProducts().add(product2);

        //When
        genericEntityRepository.save(cartFirst);
        Long id = cartFirst.getId();
        Cart cartById = (Cart) genericEntityRepository.getOne(id);

        //Then
        Assert.assertEquals(2,cartById.getProducts().size());
    }

    @Test
    public void testCartUpdate(){

        //Given
        Product product1 = new Product("cereals","chocolate",8.99);
        Product product2 = new Product("milk","cow-milk",2.99);
        List<Product> productsFirstCart = new ArrayList<>();
        Cart cartFirst = new Cart(productsFirstCart);
        cartFirst.getProducts().add(product1);
        cartFirst.getProducts().add(product2);
        genericEntityRepository.save(cartFirst);
        Long id = cartFirst.getId();
        Cart cartToUpdate = (Cart) genericEntityRepository.getOne(id);

        //When
        cartToUpdate.getProducts().add(new Product("strawberries","extra-sweet",7.00));
        genericEntityRepository.save(cartToUpdate);
        id = cartToUpdate.getId();
        Cart cartUpdated = (Cart) genericEntityRepository.getOne(id);

        //Then
        Assert.assertEquals(3,cartUpdated.getProducts().size());

    }

    @Test
    public void testCartDelete(){

        //Given
        Product product1 = new Product("cereals","chocolate",8.99);
        Product product2 = new Product("milk","cow-milk",2.99);
        List<Product> productsFirstCart = new ArrayList<>();
        Cart cartFirst = new Cart(productsFirstCart);
        cartFirst.getProducts().add(product1);
        cartFirst.getProducts().add(product2);

        Product product3 = new Product("bread","grandma-bread",3.90);
        Product product4 = new Product("butter","from happy cows",7.90);
        List<Product> productsSecondtCart = new ArrayList<>();
        Cart cartSecond = new Cart(productsSecondtCart);
        cartSecond.getProducts().add(product3);
        cartSecond.getProducts().add(product4);

        genericEntityRepository.save(cartFirst);
        genericEntityRepository.save(cartSecond);

        //When
        long cartCounterBeforeDeletion = genericEntityRepository.count();
        genericEntityRepository.delete(cartSecond);
        long cartCounter = genericEntityRepository.count();

        //Then
        Assert.assertEquals(cartCounterBeforeDeletion-1, cartCounter);
    }

}

