package com.callisto.productservice.controller;

import static org.mockito.Mockito.when;

import com.callisto.productservice.dto.ProductRequest;
import com.callisto.productservice.dto.ProductResponse;
import com.callisto.productservice.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link ProductController#createProduct(ProductRequest)}
     */
    @Test
    void testCreateProduct() throws Exception {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

        ProductRequest productRequest = new ProductRequest();
        productRequest.setDescription("The characteristics of someone or something");
        productRequest.setId("42");
        productRequest.setName("Name");
        productRequest.setPrice(BigDecimal.valueOf(42L));
        String content = (new ObjectMapper()).writeValueAsString(productRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProductController#createProduct(ProductRequest)}
     */
    @Test
    void testCreateProduct2() throws Exception {
        ArrayList<ProductResponse> productResponseList = new ArrayList<>();
        productResponseList.add(new ProductResponse());
        when(productService.getAllProducts()).thenReturn(productResponseList);

        ProductRequest productRequest = new ProductRequest();
        productRequest.setDescription("The characteristics of someone or something");
        productRequest.setId("42");
        productRequest.setName("Name");
        productRequest.setPrice(BigDecimal.valueOf(42L));
        String content = (new ObjectMapper()).writeValueAsString(productRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"id\":null,\"name\":null,\"description\":null,\"price\":null}]"));
    }
}