package org.group5.service;


import org.group5.model.Order;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Neha on 7/11/2016.
 */

public interface OrderService {

    void add(Order transaction);
    void update(Order transaction);
    void delete(long id);
    Order findById(long id);
    Set<Order> getAll();

}
