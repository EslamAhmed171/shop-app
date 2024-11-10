package org.example.orderservice.dto;


import java.math.BigDecimal;


public class ItemDto {
    private String code;
    private BigDecimal price;
    private int quantity;

    public ItemDto() {}

    public ItemDto(String code, BigDecimal price, int quantity) {
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
