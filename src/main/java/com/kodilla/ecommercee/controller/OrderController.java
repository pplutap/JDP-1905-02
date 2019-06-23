package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.OrderService;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins =  "https://glacial-reef-77706.herokuapp.com")
@RestController
@RequestMapping("/superShop")
public class OrderController {

<<<<<<< HEAD
    private static final ProductDto butter = new ProductDto("SuperButter", "Super Fat Butter.", 3.99, "28");
    private static final ProductDto meal = new ProductDto("Mega Meal", "Epic meal moment.", 8.99, "34");
    private static final ProductDto socks = new ProductDto("Sport socks", "Most breathable fabric.", 9.99, "5");
    private static final ProductDto tshirt = new ProductDto("UV T-Shirt", "100% UV protection", 29.99, "5");
    private static final OrderDto firstOrder = new OrderDto(1L, 2019, 05, 28, true, false, Arrays.asList(butter, meal));
    private static final OrderDto secondOrder = new OrderDto(2L, 2019, 05, 31, false, false, Arrays.asList(socks, tshirt));
=======
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;
>>>>>>> start

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(orderService.getAllOrders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestParam Long cartId) {
        orderService.setUserId(userService.getUserId());
        orderService.setCart(cartService.getCart());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public Order getOrder(@RequestParam Long orderId){
        return orderService.getOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestParam Long cartId) {
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapCartToOrder(cartService.getCart(cartId))));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(Long orderId){
        orderService.deleteOrder(orderId);
    }
}

