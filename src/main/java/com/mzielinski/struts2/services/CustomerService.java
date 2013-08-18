package com.mzielinski.struts2.services;

import com.mzielinski.struts2.model.Customer;

import java.util.List;

/**
 * @author mzielinski, Rule Financial
 */
public interface CustomerService {

    Customer add(Customer customer);

    Customer delete(Long id);

    Customer show(Long id);

    List<Customer> list();

}
