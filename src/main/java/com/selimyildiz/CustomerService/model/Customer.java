package com.selimyildiz.CustomerService.model;

import lombok.Data;

@Data
public class Customer
{
    private int id;
    private String name;
    private String lastName;

    public Customer()
    {

    }
    public Customer(int id, String name, String lastName)
    {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}
