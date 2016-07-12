package org.group5.service.impl;

import org.group5.dao.OrderDao;
import org.group5.model.Order;
import org.group5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Neha on 7/11/2016.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void add(Order order) {
        orderDao.save(order);
    }

    @Override
    public void update(Order order) {
        orderDao.save(order);
    }

    @Override
    public void delete(long id) {
        orderDao.delete(id);
    }

    @Override
    public Order findById(long id) {
        return orderDao.findOne(id);
    }

    @Override
    public Set<Order> getAll() {
        Set<Order> result = new HashSet<>();
        orderDao.findAll().forEach(item -> result.add(item));
        return result;
    }
}
