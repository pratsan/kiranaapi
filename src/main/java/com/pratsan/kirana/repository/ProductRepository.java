package com.pratsan.kirana.repository;

import com.pratsan.kirana.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Long> {

    Optional<Products> findBySellerId(String sellerId);
}
