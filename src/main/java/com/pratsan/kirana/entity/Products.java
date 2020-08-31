package com.pratsan.kirana.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Products implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long productId;
private  String sellerId;
    @Column(name = "sellerId")
@OneToMany(mappedBy = "products")
List<ProductList> productList;

}
