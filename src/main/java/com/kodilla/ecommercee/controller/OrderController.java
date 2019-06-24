package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderCreationDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins =  "https://glacial-reef-77706.herokuapp.com")
@RestController
@RequestMapping("/superShop")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(orderService.getAllOrders());
    }
      
    @PostMapping(path = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderCreationDto orderCreationDto) {
        orderService.saveOrder(orderCreationDto);
    }

    @GetMapping(path = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId){
        return orderMapper.mapToOrderDto(orderService.getOrder(orderId));
    }

    @PutMapping(path = "updateOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderCreationDto));
    }

    @DeleteMapping(path = "deleteOrder")
    public void deleteOrder(Long orderId){
        orderService.deleteOrder(orderId);
    }
}

