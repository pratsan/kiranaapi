package com.pratsan.kirana.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "customerAddressList")
public class CustomerAddressList implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_address_id")
    private Long customerAddressId;
    private String doorNo;
    private String street;
    private  String pincode;
    private String phoneNo;

    @ManyToOne(fetch = FetchType.EAGER)
    private  CustomerAddress customerAddress;
}
