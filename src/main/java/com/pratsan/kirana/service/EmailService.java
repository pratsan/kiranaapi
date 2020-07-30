package com.pratsan.kirana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
@Autowired
private JavaMailSender javaMailSender;
@Autowired
    SimpleMailMessage simpleMailMessage;
public boolean customerSignupOtp(String email,int otp)
{
    try{
        simpleMailMessage.setText("your otp no is"+otp);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Kirana otp");
        javaMailSender.send(simpleMailMessage);
        System.out.println("email success");
    return true;
    }
    catch (Exception e)
    {
        System.out.println("email falil"+e.getMessage());
        return  false;
    }
}
}
