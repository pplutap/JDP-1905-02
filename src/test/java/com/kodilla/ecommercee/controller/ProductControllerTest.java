package com.kodilla.ecommercee.controller;

import com.google.gson.Gson;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    private final static Group group = new Group("test group");
    private final static Product product = new Product("product", "test product", 9.99, group);
    private final static ProductDto productDto = new ProductDto("product", "test product", 9.99, "1");
    private static Gson gson = new Gson();
    private final static String jsonContent = gson.toJson(productDto);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @MockBean
    private ProductMapper productMapper;

    @Test
    public void getProductsTest() throws Exception{
        mockMvc.perform(get("/superShop/getProducts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getProductAndCreateProductTest() throws Exception {
        when(service.getProduct(anyLong())).thenReturn(product);
        when(productMapper.mapToProductDto(ArgumentMatchers.any())).thenReturn(productDto);

        mockMvc.perform(get("/superShop/getProduct?productId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createProductTest() throws Exception {
        when(productMapper.mapToProductDto(ArgumentMatchers.any())).thenReturn(productDto);
        when(service.saveProduct(ArgumentMatchers.any())).thenReturn(product);

        mockMvc.perform(post("/superShop/createProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void updateProductTest() throws Exception{
        when(productMapper.mapToProduct(ArgumentMatchers.any())).thenReturn(product);
        when(service.saveProduct(ArgumentMatchers.any())).thenReturn(product);
        when(productMapper.mapToProductDto(ArgumentMatchers.any())).thenReturn(productDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/superShop/updateProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteProduct() throws Exception{

    }

}