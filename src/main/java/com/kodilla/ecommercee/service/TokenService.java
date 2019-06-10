package com.kodilla.ecommercee.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Transactional
@Service
public class TokenService {

    private Random randomGenerator = new Random();

    public String generateRandomKey(){

        int keySize = 5;
        String key = "";

        for (int i=0; i<keySize; i++) {
            int generatedNumber = randomGenerator.nextInt(9);
            key += generatedNumber;

        }
        return key;
    }

}
