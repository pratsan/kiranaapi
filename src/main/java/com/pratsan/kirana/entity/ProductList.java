package com.pratsan.kirana.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_list")
@Data
public class ProductList implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productListId;
    private String productName;
    @Lob
    private byte[] productImage;
    private String description;
    private int quantity;
    private int price;
    private boolean stock;
    @ManyToOne
    Products products;
}
