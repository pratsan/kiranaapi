package com.pratsan.kirana.repository;

import com.pratsan.kirana.entity.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductListRepository extends JpaRepository<ProductList,Long> {
}
