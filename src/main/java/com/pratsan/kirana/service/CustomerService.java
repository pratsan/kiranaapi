package com.pratsan.kirana.service;

import com.pratsan.kirana.dto.CustomerAddressDto;
import com.pratsan.kirana.dto.CustomerDto;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.exception.CustomerAddressException;
import com.pratsan.kirana.exception.CustomerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
  ResponseDto fetchCustomerAddress(String customerId) throws CustomerAddressException;
  ResponseDto storeCustomerAddress(String customerId,CustomerAddressDto customerAddressDto) throws CustomerException, CustomerAddressException;
  ResponseDto registerCustomer(String customerId);


}
