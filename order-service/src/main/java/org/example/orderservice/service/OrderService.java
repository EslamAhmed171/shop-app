package org.example.orderservice.service;

import brave.Span;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import org.example.orderservice.dto.ItemDto;
import org.example.orderservice.dto.OrderRequest;
import org.example.orderservice.event.OrderPlacedEvent;
import org.example.orderservice.model.Order;
import org.example.orderservice.model.Item;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final ObservationRegistry observationRegistry;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;


    public OrderService(OrderRepository orderRepository,
                        WebClient.Builder webClientBuilder,
                        ObservationRegistry observationRegistry,
                        KafkaTemplate kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.webClientBuilder = webClientBuilder;
        this.observationRegistry = observationRegistry;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        order.setItems(orderRequest.getItemDtoList()
                .stream()
                .map(itemDto-> mapToOrderItems(itemDto, order))
                .toList());
        // call inventory service, place order if product is in stock
        Map<String, String> items = order.getItems().
                stream().
                collect(Collectors.toMap(Item::getCode, item -> String.valueOf(item.getQuantity())));

        // Convert the Map<String, String> to MultiValueMap<String, String>
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.setAll(items);

        Observation inventoryServiceObservation = Observation.createNotStarted("inventory-service-lookup",
                this.observationRegistry);
        inventoryServiceObservation.lowCardinalityKeyValue("call", "inventory-service");

        return inventoryServiceObservation.observe(() ->{
            boolean result = Boolean.TRUE.equals(webClientBuilder.build().get()
                    .uri(uriBuilder -> uriBuilder
                            .scheme("http")
                            .host("inventory-service")
                            .path("/api/inventory")
                            .queryParams(queryParams)
                            .build())
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block());
            if (result) {
                orderRepository.save(order);
                kafkaTemplate.send("order-notification", new OrderPlacedEvent(order.getOrderNumber()));
                return "Order placed successfully";
            }
            else {
                throw new RuntimeException("Product is out of stock, please try again later");
            }
        });
    }

    private Item mapToOrderItems(ItemDto itemDto, Order order) {
        Item item = new Item();
        item.setOrder(order);
        item.setCode(itemDto.getCode());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        return item;
    }
}