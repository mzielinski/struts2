package com.mzielinski.struts2.view;

import com.mzielinski.struts2.model.Customer;
import com.mzielinski.struts2.services.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

import java.util.List;

/**
 * @author mzielinski, Rule Financial
 */
public class CustomerAction extends ActionSupport {

    private static final long serialVersionUID = 9149826260758390091L;

    private Long id;
    private Customer customer;
    private List<Customer> customerList;

    @Inject("customerService")
    private CustomerService customerService;

    public String execute() {
        this.customerList = customerService.list();
        System.out.println("execute called");
        return SUCCESS;
    }

    public String show() {
        this.customer = customerService.show(getId());
        return SUCCESS;
    }

    public String add() {
        System.out.println(getCustomer());
        try {
            customerService.add(getCustomer());
        } catch (Exception e) {
            System.err.println(e);
        }
        this.customerList = customerService.list();
        return SUCCESS;
    }

    public String delete() {
        customerService.delete(getId());
        return SUCCESS;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerList(List<Customer> customersList) {
        this.customerList = customersList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}