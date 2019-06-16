package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUser(final Long id) {
        return repository.findById(id);
    }

    public User saveUser(final User product) {
        return repository.save(product);
    }

    @Transactional
    public void deleteUser(final Long id){
        repository.deleteById(id);
    }
}
