package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTests {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveOrder() {

        //Given
        Group group = new Group("test group");
        Product product = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90, group);
        productRepository.save(product);
        List<Product> productList = new ArrayList<>();
        productList.add(product);

        User user = new User("Konrad Kozłowski");
        userRepository.save(user);

        Cart cart = new Cart(productList);
        cartRepository.save(cart);

        Order order = new Order(user, cart);

        //When
        orderRepository.save(order);
        Long id = order.getId();
        Order foundOrder = orderRepository.getOne(id);

        //Then
        Assert.assertNotEquals(null, foundOrder);

    }

    @Test
    public void testUpdateOrder() {

        //Given
        Group group = new Group("test group");
        Product product = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90, group);
        productRepository.save(product);
        List<Product> productList = new ArrayList<>();
        productList.add(product);

        User user = new User("Konrad Kozłowski");
        userRepository.save(user);

        Cart cart = new Cart(productList);
        cartRepository.save(cart);

        Order order = new Order(user, cart);
        orderRepository.save(order);
        Long id = order.getId();

        User newUser = new User("Zygmunt Mysłowicz");

        //When
        order.setUser(newUser);
        orderRepository.save(order);

        String updatedOrderUserName = orderRepository.getOne(id).getUser().getUsername();

        //Then
        Assert.assertEquals("Zygmunt Mysłowicz", updatedOrderUserName);

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

        List<Product> productList1 = new ArrayList<>();
        List<Product> productList2 = new ArrayList<>();
        List<Product> productList3 = new ArrayList<>();

        productList1.add(product1);
        productList1.add(product2);
        productList2.add(product3);
        productList2.add(product2);
        productList3.add(product3);
        productList3.add(product1);

        User user1 = new User("Konrad Kozłowski");
        User user2 = new User("Marta Bednarczyk");
        User user3 = new User("Katarzyna Kwiek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Cart cart1 = new Cart(productList1);
        Cart cart2 = new Cart(productList2);
        Cart cart3 = new Cart(productList3);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);


        Order order1 = new Order(user1, cart1);
        Order order2 = new Order(user2, cart2);
        Order order3 = new Order(user3, cart3);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);


        //When
        long orderCounterBeforeDeletion = orderRepository.count();
        orderRepository.delete(order1);
        long orderCounter = orderRepository.count();


        //Then
        Assert.assertEquals(orderCounterBeforeDeletion-1, orderCounter);
    }

    @Test
    public void getOrder() {

        //Given
        Group group = new Group("test group");
        Product product1 = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90, group);
        Product product2 = new Product("Krzesło Romea", "Krzesło składane z drewna ...", 66.90, group);
        Product product3 = new Product("Wkrętarka udarowa", "Wkrętarka marki Hilti ...", 3980.90, group);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        List<Product> productList1 = new ArrayList<>();
        List<Product> productList2 = new ArrayList<>();
        List<Product> productList3 = new ArrayList<>();

        productList1.add(product1);
        productList1.add(product2);
        productList2.add(product3);
        productList2.add(product2);
        productList3.add(product3);
        productList3.add(product1);

        User user1 = new User("Konrad Kozłowski");
        User user2 = new User("Marta Bednarczyk");
        User user3 = new User("Katarzyna Kwiek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Cart cart1 = new Cart(productList1);
        Cart cart2 = new Cart(productList2);
        Cart cart3 = new Cart(productList3);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);

        Order order1 = new Order(user1, cart1);
        Order order2 = new Order(user2, cart2);
        Order order3 = new Order(user3, cart3);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        //When
        Long id = order1.getId();
        Order foundOrder = orderRepository.getOne(id);
        String userName = foundOrder.getUser().getUsername();
        String firstProductName = foundOrder.getCart().getProducts().get(0).getName();

        //Then
        Assert.assertEquals("Konrad Kozłowski", userName);
        Assert.assertEquals("Altana SunSet", firstProductName);

    }

    @Test
    public void getOrders() {

        //Given
        Group group = new Group("test group");
        Product product1 = new Product("Altana SunSet", "Altana ogrodowa ...", 999.90, group);
        Product product2 = new Product("Krzesło Romea", "Krzesło składane z drewna ...", 66.90, group);
        Product product3 = new Product("Wkrętarka udarowa", "Wkrętarka marki Hilti ...", 3980.90, group);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        List<Product> productList1 = new ArrayList<>();
        List<Product> productList2 = new ArrayList<>();
        List<Product> productList3 = new ArrayList<>();

        productList1.add(product1);
        productList1.add(product2);
        productList2.add(product3);
        productList2.add(product2);
        productList3.add(product3);
        productList3.add(product1);

        User user1 = new User("Konrad Kozłowski");
        User user2 = new User("Marta Bednarczyk");
        User user3 = new User("Katarzyna Kwiek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Cart cart1 = new Cart(productList1);
        Cart cart2 = new Cart(productList2);
        Cart cart3 = new Cart(productList3);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);

        int orderCounterBeforeSave = orderRepository.findAll().size();

        Order order1 = new Order(user1, cart1);
        Order order2 = new Order(user2, cart2);
        Order order3 = new Order(user3, cart3);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        //When
        int orderCounter = orderRepository.findAll().size();

        //Then
        Assert.assertEquals(orderCounterBeforeSave + 3, orderCounter);

    }

}
