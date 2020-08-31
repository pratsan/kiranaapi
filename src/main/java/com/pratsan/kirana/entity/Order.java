package com.pratsan.kirana.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private int totalQuantity;
    private int totalAmount;
    private String customerId;
    private String sellerId;
    private Long productId;
    private LocalDate orderDate;
}
