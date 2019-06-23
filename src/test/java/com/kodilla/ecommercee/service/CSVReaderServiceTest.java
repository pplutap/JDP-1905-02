package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.ProductController;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.util.List;


@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CSVReaderServiceTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CSVReaderService csvReaderService;

    String resourceFile = "src/test/resources/products.csv";

    @Test
    public void getAllProductsToList()  {
        //Given

        //When
        List<ProductDto> productDtoList = csvReaderService.CSVToBeanList(resourceFile);

        //Then
        Assert.assertEquals(4,productDtoList.size());
    }

    @Test
    public void saveProductFromList()  {
        //Given
        Group group = new Group("test group");
        groupRepository.save(group);
        List<ProductDto> productDtoList = csvReaderService.CSVToBeanList(resourceFile);
        for (ProductDto productDto: productDtoList) {
            productDto.setGroupId(String.valueOf(group.getId()));
        }

        //When
        List<ProductDto> savedProductsList = productController.createProductFromList(productDtoList);

        //Then
        for (ProductDto product:savedProductsList) {
            System.out.println(product);
        }

        for (ProductDto product:productDtoList) {
            System.out.println(product);
        }
        Assert.assertTrue(productDtoList.equals(savedProductsList));
        Assert.assertEquals(4, savedProductsList.size());
    }


}
