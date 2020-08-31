package com.pratsan.kirana.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductOrderDetail extends OrderDto{
private String productName;
private LocalDate orderDate;
}
