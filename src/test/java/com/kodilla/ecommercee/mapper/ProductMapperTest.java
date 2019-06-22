package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.service.GroupService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private GroupRepository groupRepository;


    /*private static final Group group = new Group("test group");
Product product1 = new Product("product1", "description1",1.99, group);
    private static final Product product2 = new Product("product2", "description2",2.99, group);
    ;
    private static final List<Product> products = new ArrayList<>(Arrays.asList(product1, product2))*/

    @Test
    public void mapToProductDtoList() {
        Group group = new Group("test group");
        groupRepository.save(group);

        Product product1 = new Product("product1", "description1",1.99, group);
        Product product2 = new Product("product2", "description2",2.99, group);
        List<Product> products = new ArrayList<>(Arrays.asList(product1, product2));

        ProductDto productDto1 = new ProductDto("product1", "description1",1.99, group.getId().toString());
        ProductDto productDto2 = new ProductDto("product2", "description2",2.99, group.getId().toString());
        List<ProductDto> productDtos1 = new ArrayList<>(Arrays.asList(productDto1, productDto2));
        assertThat(productDtos1, sameBeanAs(productMapper.mapToProductDtoList(products)));
    }

    @Test
    public void mapToProductDto() {
        Group group = new Group("test group");
        groupRepository.save(group);
        Product product1 = new Product("product1", "description1",1.99, group);
        ProductDto productDto11 = new ProductDto("product1", "description1",1.99, group.getId().toString());
        assertThat(productDto11 ,sameBeanAs(productMapper.mapToProductDto(product1)));
    }

    @Test
    public void mapToProduct() {
        Group group = new Group("test group");
        groupRepository.save(group);
        Product product1 = new Product("product1", "description1",1.99, group);
        ProductDto productDto11 = new ProductDto("product1", "description1",1.99, String.valueOf(group.getId()));
        Assert.assertThat(product1, sameBeanAs(productMapper.mapToProduct(productDto11)));
    }
}