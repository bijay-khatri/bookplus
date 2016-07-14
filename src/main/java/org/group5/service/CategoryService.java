package org.group5.service;

import org.group5.model.Category;

import java.util.List;

/**
 * Created by Rishi on 7/10/2016.
 */
public interface CategoryService {

    List<Category> getAll();
    void add(Category category);
    void delete(long id);
    Category findBy(long id);
    void update(Category category);

}
