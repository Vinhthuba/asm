package com.example.testapi.service;

import com.example.testapi.dao.CustomerRepository;
import com.example.testapi.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository theCustomerRepository){
        customerRepository = theCustomerRepository;}
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllOrderByLastNameAsc();
    }



    @Override
    public Customer findById(int theId) {
        Optional<Customer> results = customerRepository.findById(theId);

        Customer theEmployee = null;
        if (results.isPresent()){
            theEmployee = results.get();
        }
        else{
            throw  new RuntimeException("we did not find employee id" + theId);

        }
        return theEmployee;
    }

    @Override
    public void save(Customer theEmployee) {
        customerRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }

    @Override
    public List<Customer> searchBy(String theName) {
        List<Customer> results = null;
        if (theName != null &&(theName.trim().length()>0)){
            results = customerRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);

        }
        else {
            results = findAll();
        }
        return results;

    }
}