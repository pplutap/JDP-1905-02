package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.GenericEntity;
import com.kodilla.ecommercee.GenericEntityRepository;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private GenericEntityRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll()
                .stream()
                .filter(g -> g instanceof Product)
                .map(g -> new Product(((Product) g).getName(),
                        ((Product) g).getDescription(),((Product) g).getPrice()))
                .collect(Collectors.toList());
    }

    public Optional<GenericEntity> getProduct(final Long id) {
        return repository.findById(id);
    }

    public Product saveProduct(final Product product) {
        return (Product) repository.save(product);
    }

    @Transactional
    public void deleteProduct(final Long id){
        repository.deleteById(id);
    }
}
