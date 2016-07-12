package org.group5.dao;

import org.group5.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bijay on 7/10/2016.
 */
public interface BookDao extends JpaRepository<Book,Long> {
    //we don't need an implementation and or method unless we want to do something extra

//    @Query("SELECT b FROM Book b")
//    List<Book> getBookWithCategory();
}
