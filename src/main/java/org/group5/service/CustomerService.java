package org.group5.service;
        import org.group5.model.Customer;

import java.util.Set;
        /**
         * Created by Ghanshyam on 7/10/2016.
         */

public interface CustomerService {

    void add(Customer customer);
    void addCustomer(Customer customer);
    void update(Customer customer);
    void delete(long id);
    Customer findById(long id);
    Set<Customer> getAll();
    Customer getCustomer(String email, String password);

}