package org.group5.service.impl;

import org.group5.dao.BookDao;
import org.group5.model.Book;
import org.group5.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rishi on 7/13/2016.
 */
@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> search(String searchKey) {
        return bookDao.searchBook(searchKey);
        //(searchKey);
    }
}
