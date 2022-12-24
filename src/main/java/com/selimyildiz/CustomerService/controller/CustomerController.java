package com.selimyildiz.CustomerService.controller;

import com.selimyildiz.CustomerService.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer()
    {
        Customer customer1 = new Customer(1, "Selim", "Yildiz");
        Customer customer2 = new Customer(2, "Murat", "Yildiz");

        List<Customer> customers = Arrays.asList(customer1, customer2);

        return new ResponseEntity<>(customers, OK);
    }
}
