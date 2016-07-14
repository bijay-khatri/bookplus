package org.group5.dao;

import org.group5.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bijay on 7/10/2016.
 */
@Repository
public interface CategoryDao extends CrudRepository<Category,Long> {

    List<Category> findAllByOrderByNameAsc();
}
