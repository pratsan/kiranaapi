package com.pratsan.kirana.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customer_address")
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Long addressId;
    private String customerId;
    @Column(name = "customerAddress")
    @OneToMany(mappedBy = "customerAddress")
    List<CustomerAddressList> customerAddressList;


}
