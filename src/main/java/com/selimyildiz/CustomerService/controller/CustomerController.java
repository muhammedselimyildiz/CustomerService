package com.selimyildiz.CustomerService.controller;

import com.selimyildiz.CustomerService.model.Customer;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    private static final List<Customer> customers = new ArrayList<>();

    public CustomerController()
    {
        if (customers.isEmpty())
        {
            Customer customer1 = new Customer(1, "Selim", "Yildiz");
            Customer customer2 = new Customer(2, "Murat", "Yilmaz");

            customers.add(customer1);
            customers.add(customer2);
        }



    }
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers()
    {
        return new ResponseEntity<>(customers, OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId)
    {
        Customer result = getCustomerById(customerId);
        return new ResponseEntity<>(result, OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer)
    {
        customers.add(newCustomer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> getCustomer(@PathVariable int customerId, @RequestBody Customer newCustomer)
    {
        Customer oldCustomer = getCustomerById(customerId);
        oldCustomer.setName(newCustomer.getName());
        oldCustomer.setLastName(newCustomer.getLastName());

        return new ResponseEntity<>(OK);
    }
    private static Customer getCustomerById(int customerId)
    {
        return customers.stream().filter(customer -> customer.getId() == customerId)
                .findFirst().orElseThrow(() -> new RuntimeException("Customer not found."));
    }
}
