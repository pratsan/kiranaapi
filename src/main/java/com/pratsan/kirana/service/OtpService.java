package com.pratsan.kirana.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.pratsan.kirana.entity.CustomerOtp;
import com.pratsan.kirana.exception.OtpException;
import com.pratsan.kirana.repository.CustomerOtpRepository;
import com.pratsan.kirana.util.ApplicationConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class  OtpService {
    Logger log= LoggerFactory.getLogger(OtpService.class);
    @Autowired
    CustomerOtpRepository customerOtpRepository;
    private static final Integer EXPIRE_MINS = 1;

    private LoadingCache<String, Integer> otpCache;

    public OtpService() {

        super();
        log.info("initializing otpservice");
        otpCache = CacheBuilder.newBuilder().
                expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
            public Integer load(String key) {
                return 0;
            }
        });

    }

    public int generateOTP(String key) {
log.info("generating otp for given key"+key);
        Random random = new Random();
        String generatedOtp = String.format("%04d", random.nextInt(10000));
        int otp = Integer.valueOf(generatedOtp);
        otpCache.put(key, otp);
        return otp;
    }

    public void clearOtp(String key) {
        log.info("clearing key "+key+"from cache");
        otpCache.invalidate(key);
    }

    public Integer fetchOtp(String key) throws OtpException {
        log.info("entering fetch otp method");
        try {
      log.info("fetching otp for key "+key );
            return otpCache.get(key);
        } catch (Exception e) {
            log.error("invalid key "+key);
           throw new OtpException(ApplicationConstant.INVALID_KEY);
        }
    }

    public boolean validateOtp(String otp, Integer enteredOtp) throws OtpException {
        try {
            if (otpCache.get(otp).equals(0))
                throw new OtpException("missing");
            else if (otpCache.get(otp).intValue() == enteredOtp.intValue())
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer fetchCustomerOtp(String otp) {
        log.info("fetching otp for key "+otp );
        int otpCode=0;
        try {
            log.info("fetching otp for key "+otp);
            otpCode = otpCache.get(otp);

        } catch (Exception exception) {
            log.error("invalid key "+otp);

          log.error("invalid code"+otpCode);
        }
        return otpCode;
    }


    /**
     * Storing signup otp in DB
     */
    public boolean customerSignupotp(int otp)
    {
        log.info("entering customer signup otp method");
        try
        {
            log.info("storing customer signup otp");
            CustomerOtp customerOtp = new CustomerOtp();
            customerOtp.setLocalDate(LocalDate.now());
            customerOtp.setOtp(otp);
            customerOtp.setOtpMessage(ApplicationConstant.WAITING_FOR_OTP);
            customerOtpRepository.save(customerOtp);
            return true;
        }
        catch(Exception e)
        {
            log.error("error while storing signup otp in db"+e.getMessage());
            return false;
        }
    }
}



