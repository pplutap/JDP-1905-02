package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
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



    @Test
    public void getAllProductsAndSave()  {
        //Given
        CSVReaderService csvReaderService = new CSVReaderService();

        //When
        List<ProductDto> productDtoList = csvReaderService.CSVToBeanList();
        for(ProductDto productDto : productDtoList){
            System.out.println(productDto.getName());
        }

        //Then
        //assertThat(product1, sameBeanAs(requestedProducts.get(requestedProducts.size()-2)));


    }
}
