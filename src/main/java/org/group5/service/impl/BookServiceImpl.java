package org.group5.service.impl;

import org.group5.dao.BookDao;
import org.group5.model.Book;
import org.group5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bijay on 7/10/2016.
 */

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Override
    public void add(Book book) {
        bookDao.save(book);
    }

    @Override
    public void update(Book book) {
        bookDao.save(book);
    }

    @Override
    public void delete(long id) {
        bookDao.delete(id);
    }

    @Override
    public Book findById(long id) {
        return bookDao.findOne(id);
    }

    @Override
    public Set<Book> getAll() {
        Set<Book> result = new HashSet<>();
        bookDao.findAll().forEach(item -> result.add(item));
        return result;
    }
}
