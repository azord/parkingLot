package com.example.parking;

import Entity.Car;
import Entity.Customer;
import Repository.CarRepository;
import Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class Controller {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CarRepository carRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        return ResponseEntity.ok().body(customer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateEmployee(@PathVariable(value = "id") Integer id,
                                                    @RequestBody Customer customerDetails) throws CustomerNotFoundException {
         Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customer.setName(customerDetails.getName());
        customer.setPhone(customerDetails.getPhone());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer id)
            throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


}
