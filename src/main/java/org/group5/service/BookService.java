package org.group5.service;

import org.group5.model.Book;

import java.util.Set;

/**
 * Created by Bijay on 7/10/2016.
 */


public interface BookService {

    void add(Book book);
    void update(Book book);
    void delete(long id);
    Book findById(long id);
    Set<Book> getAll();


}
