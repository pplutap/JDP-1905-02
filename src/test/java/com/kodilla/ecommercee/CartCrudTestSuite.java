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
        productsFirstCart.add(product1);
        productsFirstCart.add(product2);
        Cart cartFirst = new Cart(productsFirstCart);

        //When
        genericEntityRepository.save(cartFirst);
        Long cartId = cartFirst.getCartId();
        Cart cartByCartId = (Cart) genericEntityRepository.getOne(cartId);

        //Then
        Assert.assertEquals(productsFirstCart,cartByCartId.getProducts());

    }

}

