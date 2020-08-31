package com.pratsan.kirana.dto;

import lombok.Data;

@Data
public class OrderDto {

    private Long productId;
    private int totalAmount;
    private int totalQuantity;


}
