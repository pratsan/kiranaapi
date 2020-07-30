package com.pratsan.kirana.controller;

import com.pratsan.kirana.dto.CustomerDto;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.exception.CustomerException;
import com.pratsan.kirana.exception.EmailException;
import com.pratsan.kirana.exception.OtpException;
import com.pratsan.kirana.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")

public class CustomerController {
@Autowired
    CustomerService customerService;
@PostMapping("")
    public ResponseEntity<ResponseDto> registerCustomer(@RequestBody CustomerDto customerDto) throws OtpException, EmailException, CustomerException {
        return new ResponseEntity<>(customerService.registerCustomer(customerDto), HttpStatus.OK);


    }

}
