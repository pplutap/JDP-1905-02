package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProduct(final Long id) {return repository.getOne(id);}


    public Product saveProduct(final Product product) {
        return repository.save(product);
    }

    @Transactional
    public void deleteProduct(final Long id){
        repository.deleteById(id);
    }
}
