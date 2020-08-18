package com.pratsan.kirana.repository;

import com.pratsan.kirana.entity.CustomerAddressList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressListRepository extends JpaRepository<CustomerAddressList,Long> {
}
