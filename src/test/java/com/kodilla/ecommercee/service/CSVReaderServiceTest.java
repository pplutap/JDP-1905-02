package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.ProductController;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CSVReaderServiceTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private CSVReaderService csvReaderService;


    @Test
    public void getAllProductsToList()  {
        //Given

        //When
        List<ProductDto> productDtoList = csvReaderService.CSVToBeanList();

        //Then
        Assert.assertEquals(4,productDtoList.size());
    }

    @Test
    public void saveProductFromList()  {
        //Given
        List<ProductDto> productDtoList = csvReaderService.CSVToBeanList();

        //When
        productController.createProductFromList(productDtoList);
        List<ProductDto> savedProductsList = productController.getProducts();


        //Then
        Assert.assertTrue(productDtoList.equals(savedProductsList));
        Assert.assertEquals(4, savedProductsList.size());
    }


}
