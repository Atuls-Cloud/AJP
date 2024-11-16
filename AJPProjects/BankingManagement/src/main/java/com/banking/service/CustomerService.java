package com.banking.service;


import com.banking.dao.CustomerDAO;
import com.banking.model.Customer;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    public Customer findCustomerById(int id) {
        return customerDAO.findCustomerById(id);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
}
