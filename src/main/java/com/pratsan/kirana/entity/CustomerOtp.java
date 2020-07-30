package com.pratsan.kirana.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class CustomerOtp {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String otpMessage;
    private LocalDate localDate;
    private int otp;


}
