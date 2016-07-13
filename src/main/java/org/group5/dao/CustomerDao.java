package org.group5.dao;

import org.group5.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Ghanshyam on 7/10/2016.
 */
public interface CustomerDao extends CrudRepository<Customer,Long> {
    //we don't need an implementation and or method unless we want to do something extra

    @Query("SELECT c FROM Customer c WHERE c.email=:email AND c.password=:password")
    Customer getUserByCredentials(@Param("email") String email, @Param("password") String password);
}