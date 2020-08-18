package com.pratsan.kirana.repository;

import com.pratsan.kirana.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long> {
    public Optional<CustomerAddress> findByCustomerId(String customerId);
}
