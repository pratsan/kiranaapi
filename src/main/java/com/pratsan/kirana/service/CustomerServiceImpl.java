package com.pratsan.kirana.service;

import com.pratsan.kirana.dto.CustomerDto;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.entity.CustomerLoginCredential;
import com.pratsan.kirana.exception.CustomerException;
import com.pratsan.kirana.exception.EmailException;
import com.pratsan.kirana.exception.OtpException;
import com.pratsan.kirana.repository.CustomerRepository;
import com.pratsan.kirana.util.ApplicationConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService {
    Logger log= LoggerFactory.getLogger(CustomerServiceImpl.class);
@Autowired
OtpService otpService;
@Autowired
EmailService emailService;
@Autowired
    CustomerRepository customerRepository;
@Autowired
ResponseDto responseDto;
private  CustomerLoginCredential customerLoginCredential;
private String customerEmail;
private int customerOtp;
    /**
     * generate an otp for customer sign up
     * @param customerDto
     * @return responseDto
     */
    @Override
    public ResponseDto<CustomerDto> registerCustomer(CustomerDto customerDto) throws OtpException, EmailException, CustomerException {
        log.info("entering registerCustomer() to register customer");
        customerEmail=customerDto.getEmail();
        Optional<CustomerLoginCredential> customerLoginCredentialOptional=customerRepository.findByEmail(customerDto.getEmail());
        if(customerLoginCredentialOptional.isPresent())
            throw new CustomerException(customerEmail+" "+ApplicationConstant.EMAIL_ALREADY_EXIST);


  customerLoginCredential=new CustomerLoginCredential();
        BeanUtils.copyProperties(customerDto,customerLoginCredential);
        customerLoginCredential.setDate(LocalDate.now());

        otpService.generateOTP(customerDto.getEmail());
        customerOtp=otpService.fetchCustomerOtp(customerEmail);
        if((emailService.customerSignupOtp(customerEmail,customerOtp))==false)
        throw new EmailException(ApplicationConstant.INVALID_EMAIL);

  otpService.customerSignupotp(otpService.fetchOtp(customerEmail));
        responseDto.setObject(customerDto);
        responseDto.setStatus_msg(ApplicationConstant.WAITING_FOR_OTP);
        responseDto.setStatus_code(otpService.fetchCustomerOtp(customerDto.getEmail()));
        return responseDto;
    }

    /**
     * validate otp entered by customer if correct then customer get registered successfully
     * @param customerEnteredOtp
     * @return
     */
    @Override
    public ResponseDto<CustomerLoginCredential> registerCustomerAfterValidate(String customerEnteredOtp) throws OtpException {
        log.info("entering registerCustomerafterValidate() method");
        int otp=otpService.fetchCustomerOtp(customerLoginCredential.getEmail());
        if(otp==Integer.valueOf(customerEnteredOtp))
        {

            customerLoginCredential.setCustomerId(new Random(1000000000).toString());
            customerRepository.save(customerLoginCredential);
            otpService.clearOtp(customerEnteredOtp);
     responseDto.setStatus_code(ApplicationConstant.SUCCESS_CODE);
     responseDto.setStatus_msg("validated successfully");
     responseDto.setObject(customerLoginCredential);
     return responseDto;
        }
        throw new OtpException(ApplicationConstant.INVALID_KEY);

    }


}
