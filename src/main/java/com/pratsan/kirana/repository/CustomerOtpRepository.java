package com.pratsan.kirana.repository;

import com.pratsan.kirana.entity.CustomerOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOtpRepository extends JpaRepository<CustomerOtp,Long> {
}
