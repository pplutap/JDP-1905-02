package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.repository.ProductRepository;
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
    private ProductRepository productRepository;

    private static final Product product1 = new Product("product1", "description1",1.99);
    private static final Product product2 = new Product("product2", "description2",2.99);

    private static final ProductDto productDto1 = new ProductDto("product1", "description1",1.99);
    private static final ProductDto productDto2 = new ProductDto("product2", "description2",2.99);

    private static final List<ProductDto> productDtos = new ArrayList<>(Arrays.asList(productDto1, productDto2));
    private static final List<Product> products = new ArrayList<>(Arrays.asList(product1, product2));

    @Test
    public void mapToProductDtoList() {
        assertThat(productDtos, sameBeanAs(productMapper.mapToProductDtoList(products)));
    }

    @Test
    public void mapToProductDto() {
        assertThat(productDto1 ,sameBeanAs(productMapper.mapToProductDto(product1)));
    }

    @Test
    public void mapToProduct() {
        productRepository.save(product1);
        productDto1.setId(product1.getId());
        Assert.assertEquals(product1, productMapper.mapToProduct(productDto1));
    }
}