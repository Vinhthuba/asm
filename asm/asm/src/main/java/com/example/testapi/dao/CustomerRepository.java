package com.example.testapi.dao;

import com.example.testapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT e FROM Customer e ORDER BY e.lastName ASC")
    List<Customer> findAllOrderByLastNameAsc();

    List<Customer> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
