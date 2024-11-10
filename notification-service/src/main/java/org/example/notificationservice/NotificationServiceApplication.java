package org.example.notificationservice;

import org.example.notificationservice.event.OrderPlacedEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.logging.Logger;


@SpringBootApplication
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notification-topic")
    public void listen(OrderPlacedEvent event) {
        Logger.getGlobal().info(event.toString());
    }
}
