package org.group5.dao;

import org.group5.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bijay on 7/10/2016.
 */
public interface BookDao extends CrudRepository<Book,Long> {
    //we don't need an implementation and or method unless we want to do something extra
}
