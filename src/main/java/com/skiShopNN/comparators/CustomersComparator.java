package com.skiShopNN.comparators;

import com.skiShopNN.model.Customer;

import java.util.Comparator;

public class CustomersComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        return customer1.getId().compareTo(customer2.getId());
    }
}
