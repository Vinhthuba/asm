package com.example.testapi.rest;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Integer id) {
        super("Không tìm thấy id: " + id);
    }
}
