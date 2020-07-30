package com.pratsan.kirana.exception;

import com.pratsan.kirana.dto.ResponseDto;
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
@ExceptionHandler(OtpException.class)
    public ResponseEntity<ResponseDto> otpError(OtpException otpException)
{
    log.error("otp exception");
    responseDto.setObject(null);
    responseDto.setStatus_msg(otpException.getMessage());
    responseDto.setStatus_code(ApplicationConstant.FAILURE_CODE);
    return new ResponseEntity<>(responseDto, HttpStatus.BAD_GATEWAY);
}
@ExceptionHandler(EmailException.class)
public ResponseEntity<ResponseDto> EmailotpError(EmailException emailException)
{
    log.error("email exception");
    responseDto.setObject(null);
    responseDto.setStatus_msg(emailException.getMessage());
    responseDto.setStatus_code(ApplicationConstant.FAILURE_CODE);
    return new ResponseEntity<>(responseDto, HttpStatus.BAD_GATEWAY);
}

@ExceptionHandler(CustomerException.class)
public ResponseEntity<ResponseDto> customerError(CustomerException customerException)
{
    log.error("email exception");
    responseDto.setObject(null);
    responseDto.setStatus_msg(customerException.getMessage());
    responseDto.setStatus_code(ApplicationConstant.FAILURE_CODE);
    return new ResponseEntity<>(responseDto, HttpStatus.ALREADY_REPORTED);
}
}
