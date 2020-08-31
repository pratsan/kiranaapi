package com.pratsan.kirana.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "customer_address")
public class CustomerAddress implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Long addressId;
    private String customerId;
    @Column(name = "customerAddress")
    @OneToMany(mappedBy = "customerAddress")
    List<CustomerAddressList> customerAddressList;


}
