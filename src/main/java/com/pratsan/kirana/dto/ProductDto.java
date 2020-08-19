package com.pratsan.kirana.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long productListId;
    private String productName;
    private byte[] productImage;
    private String description;
    private int quantity;
    private int price;
    private boolean stock;
}
