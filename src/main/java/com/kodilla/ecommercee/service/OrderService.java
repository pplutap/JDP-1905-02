package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrder(final Long id) {
        return repository.getOne(id);
    }

    public Order saveOrder(final Order order) {
        return repository.save(order);
    }

    @Transactional
    public void deleteOrder(final Long id){
        repository.deleteById(id);
    }
}
