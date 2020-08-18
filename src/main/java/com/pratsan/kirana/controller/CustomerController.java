package com.pratsan.kirana.controller;


import com.pratsan.kirana.dto.CustomerAddressDto;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.exception.CustomerAddressException;
import com.pratsan.kirana.exception.CustomerException;
import com.pratsan.kirana.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customers")

public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public String demo()
    {
        return "success";
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<ResponseDto> registerCustomeraddress(@PathVariable("customerId")String customerId) throws CustomerAddressException {
        return new ResponseEntity<>(customerService.fetchCustomerAddress(customerId),HttpStatus.ACCEPTED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<ResponseDto> getcustomerAddress(@PathVariable("customerId") String customerId,@RequestBody CustomerAddressDto customerAddressDto) throws CustomerAddressException, CustomerException {
        return new ResponseEntity<>(customerService.storeCustomerAddress(customerId,customerAddressDto),HttpStatus.ACCEPTED);

    }
    @PostMapping("")
    public ResponseEntity<ResponseDto> registerCustomer(@RequestHeader(value = "customerId") String customerId) throws CustomerAddressException, CustomerException {

        System.out.println(customerId);
        return new ResponseEntity<>(customerService.registerCustomer(customerId),HttpStatus.ACCEPTED);

    }
}
