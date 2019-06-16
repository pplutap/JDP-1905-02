package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository repository;

    public List<Cart> getAllCarts() {
        return repository.findAll();
    }

    public Optional<Cart> getCart(final Long id) {
        return repository.findById(id);
    }

    public Cart saveCart(final Cart cart) {
        return repository.save(cart);
    }

    @Transactional
    public void deleteCart(final Long id){
        repository.deleteById(id);
    }
}
