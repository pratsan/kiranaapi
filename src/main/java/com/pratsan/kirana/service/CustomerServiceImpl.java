package com.pratsan.kirana.service;

import com.pratsan.kirana.dto.CustomerAddressDto;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.entity.CustomerAddress;
import com.pratsan.kirana.entity.CustomerAddressList;
import com.pratsan.kirana.exception.CustomerAddressException;
import com.pratsan.kirana.exception.CustomerException;
import com.pratsan.kirana.repository.CustomerAddressListRepository;
import com.pratsan.kirana.repository.CustomerAddressRepository;
import com.pratsan.kirana.util.ApplicationConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerAddressRepository customerAddressRepository;
    @Autowired
    private ResponseDto responseDto;
    @Autowired
     private CustomerAddressListRepository customerAddressListRepository;
    Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public ResponseDto fetchCustomerAddress(String customerId) throws CustomerAddressException {
        Optional<CustomerAddress> customerAddress=customerAddressRepository.findByCustomerId(customerId);
        if(!customerAddress.isPresent())
        throw  new CustomerAddressException(ApplicationConstant.ADDRESS_NOT_FOUND);
            responseDto.setObject(customerAddress.get().getCustomerAddressList());
        responseDto.setStatus_code(ApplicationConstant.SUCCESS_CODE);
        responseDto.setStatus_msg(ApplicationConstant.ADDRESS_FOUND);
        return responseDto;
    }

    @Override
    public ResponseDto storeCustomerAddress(String customerId,CustomerAddressDto customerAddressDto) throws CustomerException, CustomerAddressException {
        Optional<CustomerAddress> customer=customerAddressRepository.findByCustomerId(customerId);
        if(!customer.isPresent())
            throw  new CustomerAddressException(ApplicationConstant.ADDRESS_NOT_FOUND);
        CustomerAddressList customerAddress=new CustomerAddressList();

        BeanUtils.copyProperties(customerAddressDto,customerAddress);
        customerAddress.setCustomerAddress(customer.get());
        customerAddressListRepository.save(customerAddress);
       responseDto.setObject(customerAddress);
       responseDto.setStatus_msg(ApplicationConstant.ADDRESS_REGISTERED_SUCC);
       responseDto.setObject(ApplicationConstant.SUCCESS_CODE);
        return responseDto;
    }

    @Override
    public ResponseDto registerCustomer(String customerId) {
        Optional<CustomerAddress> customer=customerAddressRepository.findByCustomerId(customerId);
        if(!customer.isPresent()) {
            CustomerAddress customerAddress = new CustomerAddress();
            customerAddress.setCustomerId(customerId);
            customerAddressRepository.save(customerAddress);
            responseDto.setObject(customerAddress);
            responseDto.setStatus_msg(ApplicationConstant.CUSTOMER_REGISTERED_SUCC);
            responseDto.setObject(ApplicationConstant.SUCCESS_CODE);

        }
        else{
            responseDto.setStatus_msg(ApplicationConstant.CUSTOMER_ALREADY_REGISTERED);
            responseDto.setObject(ApplicationConstant.SUCCESS_CODE);
        }

        return responseDto;
    }
}
