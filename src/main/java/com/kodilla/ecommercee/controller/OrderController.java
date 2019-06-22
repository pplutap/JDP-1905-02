package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins =  "https://glacial-reef-77706.herokuapp.com")
@RestController
@RequestMapping("/superShop")
public class OrderController {

    private static final ProductDto butter = new ProductDto("SuperButter", "Super Fat Butter.", 3.99);
    private static final ProductDto meal = new ProductDto("Mega Meal", "Epic meal moment.", 8.99);
    private static final ProductDto socks = new ProductDto("Sport socks", "Most breathable fabric.", 9.99);
    private static final ProductDto tshirt = new ProductDto("UV T-Shirt", "100% UV protection", 29.99);
    private static final OrderDto firstOrder = new OrderDto(1L, 2019, 05, 28, true, false, Arrays.asList(butter, meal));
    private static final OrderDto secondOrder = new OrderDto(2L, 2019, 05, 31, false, false, Arrays.asList(socks, tshirt));

    @GetMapping(path = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>(Arrays.asList(firstOrder, secondOrder));
    }

    @PostMapping(path = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder() {
    }

    @GetMapping(path = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId){
        return new OrderDto(1L, 2019, 03, 03, true, true, new ArrayList<ProductDto>());
    }

    @PutMapping(path = "updateOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, 2019, 03, 03, false, false, new ArrayList<ProductDto>());
    }

    @DeleteMapping(path = "deleteOrder")
    public void deleteOrder(Long orderId){
    }

}

