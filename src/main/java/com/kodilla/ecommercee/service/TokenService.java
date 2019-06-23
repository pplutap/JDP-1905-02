package com.kodilla.ecommercee.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Transactional
@Service
public class TokenService {

    private Random randomGenerator = new Random();

    public Long generateRandomKey(){

        int keySize = 5;
        String key = String.valueOf(randomGenerator.nextInt(8) +1);

        for (int i=1; i<keySize; i++) {
            int generatedNumber = randomGenerator.nextInt(9);
            key += generatedNumber;
        }
        return Long.parseLong(key);
    }
}
