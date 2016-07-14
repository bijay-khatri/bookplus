package org.group5.service;

import org.group5.model.Book;

import java.util.List;

/**
 * Created by Rishi on 7/13/2016.
 */
public interface SearchService {
   List<Book> search(String searchKey);
}
