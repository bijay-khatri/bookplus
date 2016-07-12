package org.group5.dao;

import org.group5.model.ProductCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Example on 7/10/2016.
 */
@Repository
public interface ProductCopyDao extends JpaRepository<ProductCopy,Long> {
}
