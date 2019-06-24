package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public List<OrderDto> mapToOrderDtoList(final List<Order> orders) {
        return orders.stream()
                .map(o -> new OrderDto(o.getId(), o.getUser().getUsername(),
                        o.getCart().getProducts().stream().map(p -> p.getId().toString() + ", ")
                                .collect(Collectors.joining()))).collect(Collectors.toList());
    }

    public OrderDto mapToOrderDto(Order order){
        return new OrderDto(order.getId(), order.getUser().getUsername(),
                order.getCart().getProducts().stream().map(p -> p.getId().toString() + ", ").collect(Collectors.joining()));
    }
}
