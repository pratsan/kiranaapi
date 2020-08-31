package com.pratsan.kirana.repository;

import com.pratsan.kirana.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

   public List<Order> findByCustomerId(String customerId);
}
