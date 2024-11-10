package org.example.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productservice.dto.ProductRequest;
import org.example.productservice.repository.ProductRepository;
import org.example.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private ProductService productService;
//
//    @Container
//    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");
//
//    @DynamicPropertySource
//    static void setProperties (DynamicPropertyRegistry registry){
//        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//    }
//
//    @Test
//    void shouldCreateProduct () throws Exception {
//        ProductRequest productRequest = getProductRequest();
//        String proudctRequestString = objectMapper.writeValueAsString(productRequest);
//
//        mockMvc.perform(post("/api/product")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(proudctRequestString))
//                .andExpect(status().isCreated());
//        assertEquals(productRepository.findAll().size(), 1);
//    }
//
//    @Test
//    void shouldGetAllProducts () throws Exception {
//        ProductRequest productRequest = getProductRequest();
//        productService.createProduct(productRequest);
//        productService.createProduct(productRequest);
//        assertEquals(productRepository.findAll().size(), 3);
//        assertEquals(productRepository.findAll().get(0).getName(), "Iphone 16");
//        assertEquals(productRepository.findAll().get(2).getName(), "Iphone 16");
//    }
//
//    private ProductRequest getProductRequest() {
//        ProductRequest productRequest = new ProductRequest();
//        productRequest.setName("Iphone 16");
//        productRequest.setDescription("Iphone 16");
//        productRequest.setPrice(BigDecimal.valueOf(100.0));
//        return productRequest;
//    }

}
