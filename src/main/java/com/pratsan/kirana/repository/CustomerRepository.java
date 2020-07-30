package com.pratsan.kirana.repository;

import com.pratsan.kirana.entity.CustomerLoginCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerLoginCredential,String>
{
Optional<CustomerLoginCredential> findByEmail(String email);

}
