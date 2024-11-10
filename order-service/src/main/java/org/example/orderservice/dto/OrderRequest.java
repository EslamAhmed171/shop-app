package org.example.orderservice.dto;
import java.util.List;


public class OrderRequest {
    private List<ItemDto> itemDtoList;

    public List<ItemDto> getItemDtoList() {
        return itemDtoList;
    }

    public void setItemDtoList(List<ItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }
}
