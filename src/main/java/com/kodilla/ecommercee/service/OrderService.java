package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderCreationDto;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    private Long userId = null;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrder(final Long id) {
        return repository.getOne(id);
    }

    public Order saveOrder(OrderCreationDto orderCreationDto) {
        User user = userRepository.getOne(orderCreationDto.getUserId());
        Cart cart = cartRepository.getOne(orderCreationDto.getCartId());
        return repository.save(new Order(user, cart));
    }

    @Transactional
    public void deleteOrder(final Long id){
        repository.deleteById(id);
    }
}