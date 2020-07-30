package com.pratsan.kirana.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name="customer_login_credential")
public class CustomerLoginCredential {
@Id
@Column(name = "customer_id",unique = true)
    private String customerId;
@Column(unique = true,updatable = false)
private String email;
private LocalDate date;


}

