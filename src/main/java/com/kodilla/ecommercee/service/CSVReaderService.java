package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.ProductDto;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderService {


    public  List<ProductDto> CSVToBeanList(String file){

        List<ProductDto> productDtoList = new ArrayList<>();
        try {
            productDtoList = new CsvToBeanBuilder(new FileReader(file))
                    .withType(ProductDto.class).withThrowExceptions(false).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return productDtoList;
    }



}
