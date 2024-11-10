package org.example.notificationservice.event;

public class OrderPlacedEvent {
    String OrderNumber;

    public OrderPlacedEvent() {

    }

    public OrderPlacedEvent(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }
}
