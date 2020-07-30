package com.pratsan.kirana.controller;

import com.pratsan.kirana.dto.CustomerDto;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.exception.OtpException;
import com.pratsan.kirana.service.CustomerService;
import com.pratsan.kirana.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/otp")
public class OtpController {
@Autowired
    OtpService otpService;
//@Autowired
CustomerDto customerDto;
@Autowired
    CustomerService customerService;
@Autowired
ResponseDto responseDto;
@PostMapping("/otp/{otp}")
public ResponseEntity<ResponseDto> validateCustomerEnteredOtp(@PathVariable String otp) throws OtpException {


    return new ResponseEntity<>(customerService.registerCustomerAfterValidate(otp), HttpStatus.OK);
}
@PostMapping("/resendotp/{otp}")
public ResponseEntity<ResponseDto> resendOtpToValidate(@PathVariable String otp) throws OtpException {


    return new ResponseEntity<>(customerService.registerCustomerAfterValidate(otp), HttpStatus.OK);
}
}
