package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.GenericEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private GenericEntityRepository repository;


}
