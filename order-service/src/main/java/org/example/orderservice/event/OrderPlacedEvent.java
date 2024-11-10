package org.example.orderservice.event;

public class OrderPlacedEvent {
    String orderNumber;

    public OrderPlacedEvent(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderPlacedEvent() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
