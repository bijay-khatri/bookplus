package org.group5.service;

import org.group5.model.ProductCopy;

import java.util.Set;

/**
 * Created by Example on 7/10/2016.
 */
public interface ProductCopyService {
    void add(ProductCopy copy);
    void update(ProductCopy copy);
    void delete(long id);
    ProductCopy findById(long id);
    Set<ProductCopy> getAll();
}
