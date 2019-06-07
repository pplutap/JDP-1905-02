package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.OrderNotFoundException;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/superShop")
public class OrderController {

    private static final ProductDto butter = new ProductDto(1L, "SuperButter", "Super Fat Butter.", 3.99, 1L);
    private static final ProductDto meal = new ProductDto(2L, "Mega Meal", "Epic meal moment.", 8.99, 1L);
    private static final ProductDto socks = new ProductDto(3L, "Sport socks", "Most breathable fabric.", 9.99, 2L);
    private static final ProductDto tshirt = new ProductDto(4L, "UV T-Shirt", "100% UV protection", 29.99, 2L);
    private static final OrderDto firstOrder = new OrderDto(1L, 2019, 05, 28, true, false, Arrays.asList(butter, meal));
    private static final OrderDto secondOrder = new OrderDto(2L, 2019, 05, 31, false, false, Arrays.asList(socks, tshirt));

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>(Arrays.asList(firstOrder, secondOrder));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder() {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return new OrderDto(1L, 2019, 03, 03, true, true, new ArrayList<ProductDto>());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, 2019, 03, 03, false, false, new ArrayList<ProductDto>());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(Long orderId) throws OrderNotFoundException {
    }

}

