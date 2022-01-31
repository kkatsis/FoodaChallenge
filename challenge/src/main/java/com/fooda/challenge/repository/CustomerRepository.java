package com.fooda.challenge.repository;

import com.fooda.challenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer getById(String Id);
}
