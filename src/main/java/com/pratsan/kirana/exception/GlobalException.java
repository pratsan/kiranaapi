package com.pratsan.kirana.exception;

import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.entity.CustomerAddress;
import com.pratsan.kirana.util.ApplicationConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
    Logger log= LoggerFactory.getLogger(GlobalException.class);
    @Autowired
    ResponseDto responseDto;

@ExceptionHandler(CustomerAddressException.class)
public ResponseEntity<ResponseDto> customerError(CustomerAddressException customerAddressException)
{
    log.error("address not found");
    responseDto.setObject(null);
    responseDto.setStatus_msg(customerAddressException.getMessage());
    responseDto.setStatus_code(ApplicationConstant.FAILURE_CODE);
    return new ResponseEntity<>(responseDto, HttpStatus.ALREADY_REPORTED);
}
}
