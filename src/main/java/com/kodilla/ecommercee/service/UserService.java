package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(final Long id) {
        return repository.getOne(id);
    }

    public User saveUser(final User product) {
        return repository.save(product);
    }

    public void blockUser(final Long id){
        repository.updateUserSetStatusForId("BLOCKED", id);
        User user = getUser(id);
        entityManager.refresh(user);
    }

    public void setUserKey(final Long userKey, final Long id){
        repository.updateUserSetUserKeyForId(userKey, id);
        User user = getUser(id);
        entityManager.refresh(user);
    }

    @Transactional
    public void deleteUser(final Long id){
        repository.deleteById(id);
    }
}
