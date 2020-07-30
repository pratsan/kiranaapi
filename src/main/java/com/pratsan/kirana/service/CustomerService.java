package com.pratsan.kirana.service;

import com.pratsan.kirana.dto.CustomerDto;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.entity.CustomerLoginCredential;
import com.pratsan.kirana.exception.CustomerException;
import com.pratsan.kirana.exception.EmailException;
import com.pratsan.kirana.exception.OtpException;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public ResponseDto<CustomerDto> registerCustomer(CustomerDto customerDto) throws OtpException, EmailException, CustomerException;
    public ResponseDto<CustomerLoginCredential> registerCustomerAfterValidate(String customerEnteredOtp) throws OtpException;

}
