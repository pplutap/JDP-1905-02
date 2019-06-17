package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.ProductDto;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderService {

    private final static String readingFile = "C:\\Users\\lukasz\\Documents\\kodilla\\products.csv";
    public  List<ProductDto> CSVToBeanList(){
        List<ProductDto> productDtoList = new ArrayList<>();
        try {
            productDtoList = new CsvToBeanBuilder(new FileReader(readingFile))
                    .withType(ProductDto.class).build().parse();
            System.out.println(productDtoList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return productDtoList;
    }



}
