package com.example.parking;

public class CustomerNotFoundException extends Exception{
    CustomerNotFoundException(Integer id) {
        super("Could not find customer " + id);
    }
}
