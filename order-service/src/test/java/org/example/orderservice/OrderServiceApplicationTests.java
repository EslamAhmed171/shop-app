package org.example.orderservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.orderservice.dto.ItemDto;
import org.example.orderservice.dto.OrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class OrderServiceApplicationTests {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Container
//    private static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:latest");
//
//    @DynamicPropertySource
//    static void properties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", mySQLContainer::getUsername);
//        registry.add("spring.datasource.password", mySQLContainer::getPassword);
//        registry.add("spring.datasource.driver-class-name", mySQLContainer::getDriverClassName);
//    }
//
//    @Test
//    void testPlaceOrder() throws Exception {
//        String orderRequestString = dummyOrderRequestAsString();
//        mockMvc.perform(post("/api/order")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(orderRequestString))
//                .andExpect(status().isCreated());
//
//    }
//
//    private String dummyOrderRequestAsString() throws Exception {
//        OrderRequest orderRequest = new OrderRequest();
//        List<ItemDto> itemDtoList = new ArrayList<>();
//        itemDtoList.add(new ItemDto("1", BigDecimal.valueOf(10.9), 10));
//        itemDtoList.add(new ItemDto("2", BigDecimal.valueOf(20.9), 20));
//        itemDtoList.add(new ItemDto("3", BigDecimal.valueOf(30.9), 30));
//        orderRequest.setItemDtoList(itemDtoList);
//
//        return objectMapper.writeValueAsString(orderRequest);
//    }

}
