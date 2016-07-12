package org.group5.service.impl;

import org.group5.dao.ProductCopyDao;
import org.group5.model.ProductCopy;
import org.group5.service.ProductCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Example on 7/10/2016.
 */
@Service
@Transactional
public class ProductCopyImpl implements ProductCopyService {
    @Autowired
    private ProductCopyDao productcopyDao;
    @Override
    public void add(ProductCopy copy) {
        productcopyDao.save(copy);
    }

    @Override
    public void update(ProductCopy copy) {
        productcopyDao.save(copy);
    }

    @Override
    public void delete(long id) {
        productcopyDao.delete(id);
    }

    @Override
    public ProductCopy findById(long id) {
        return productcopyDao.findOne(id);
    }

    @Override
    public Set<ProductCopy> getAll() {
        Set<ProductCopy> result = new HashSet<>();
        productcopyDao.findAll().forEach(item -> result.add(item));
        return result;
    }
}
