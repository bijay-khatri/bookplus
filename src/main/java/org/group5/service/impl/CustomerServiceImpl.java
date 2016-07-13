package org.group5.service.impl;

import org.group5.dao.CustomerDao;
import org.group5.model.Customer;
import org.group5.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ghanshyam on 7/10/2016.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Override
    public void add(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.save(customer);
    }


    @Override
    public void delete(long id) {
        customerDao.delete(id);
    }

    @Override
    public Customer findById(long id) {
        return customerDao.findOne(id);
    }

    @Override
    public Set<Customer> getAll() {
        Set<Customer> result = new HashSet<>();
        customerDao.findAll().forEach(item -> result.add(item));
        return result;
    }
    @Override
    public Customer getCustomer(String email, String password) {
        return customerDao.getUserByCredentials(email, password);


    }


}