package org.group5.service.impl;

import org.group5.dao.CategoryDao;
import org.group5.model.Category;
import org.group5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rishi on 7/10/2016.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;


    @Override
    public List<Category> getAll() {
//        Set<Category> result= new HashSet<>();
//        categoryDao.findAll().forEach(item->result.add(item));
//        return result;
        return categoryDao.findAllByOrderByNameAsc();
    }

    @Override
    public void add(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void delete(long id) {
        categoryDao.delete(id);

    }

    @Override
    public Category findBy(long id) {
       return categoryDao.findOne(id);
    }

    @Override
    public void update(Category category) {
       categoryDao.save(category);
    }

}
