package org.group5.dao;

import org.group5.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Neha on 7/11/2016.
 */
@Repository
public interface OrderDao extends JpaRepository<Order,Long> {
}
