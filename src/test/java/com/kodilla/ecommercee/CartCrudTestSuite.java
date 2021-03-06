package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CartCrudTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testCartSave() {

        //Given
        Group group = new Group("test group");
        Product product1 = new Product("cereals","chocolate",8.99, group);
        Product product2 = new Product("milk","cow-milk",2.99, group);
        List<Product> productsFirstCart = new ArrayList<>();
        Cart cartFirst = new Cart(productsFirstCart);
        cartFirst.getProducts().add(product1);
        cartFirst.getProducts().add(product2);

        //When
        cartRepository.save(cartFirst);
        Long id = cartFirst.getId();
        Cart cartById = cartRepository.getOne(id);

        //Then
        Assert.assertEquals(2,cartById.getProducts().size());

    }

    @Test
    public void testCartUpdate(){

        //Given
        Group group = new Group("test group");
        Product product1 = new Product("cereals","chocolate",8.99, group);
        Product product2 = new Product("milk","cow-milk",2.99, group);
        List<Product> productsFirstCart = new ArrayList<>();
        Cart cartFirst = new Cart(productsFirstCart);
        cartFirst.getProducts().add(product1);
        cartFirst.getProducts().add(product2);
        cartRepository.save(cartFirst);
        Long id = cartFirst.getId();
        Cart cartToUpdate = cartRepository.getOne(id);

        //When
        cartToUpdate.getProducts().add(new Product("strawberries","extra-sweet",7.00, group));
        cartRepository.save(cartToUpdate);
        id = cartToUpdate.getId();
        Cart cartUpdated = cartRepository.getOne(id);

        //Then
        Assert.assertEquals(3,cartUpdated.getProducts().size());

    }

    @Test
    public void testCartDelete(){

        //Given
        Group group = new Group("test group");
        Product product1 = new Product("cereals","chocolate",8.99, group);
        Product product2 = new Product("milk","cow-milk",2.99, group);
        List<Product> productsFirstCart = new ArrayList<>();
        Cart cartFirst = new Cart(productsFirstCart);
        cartFirst.getProducts().add(product1);
        cartFirst.getProducts().add(product2);

        Product product3 = new Product("bread","grandma-bread",3.90, group);
        Product product4 = new Product("butter","from happy cows",7.90, group);
        List<Product> productsSecondtCart = new ArrayList<>();
        Cart cartSecond = new Cart(productsSecondtCart);
        cartSecond.getProducts().add(product3);
        cartSecond.getProducts().add(product4);

        cartRepository.save(cartFirst);
        cartRepository.save(cartSecond);

        //When
        long cartCounterBeforeDeletion = cartRepository.count();
        cartRepository.delete(cartSecond);
        long cartCounter = cartRepository.count();

        //Then
        Assert.assertEquals(cartCounterBeforeDeletion-1, cartCounter);

    }

}
