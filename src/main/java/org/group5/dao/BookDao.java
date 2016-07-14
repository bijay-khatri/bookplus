package org.group5.dao;

import org.group5.model.Book;
import org.group5.model.Category;
import org.group5.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * Created by Bijay on 7/10/2016.
 */
public interface BookDao extends JpaRepository<Book,Long> {
    //we don't need an implementation and or method unless we want to do something extra

//    @Query("SELECT b FROM Book b")
//    List<Book> getBookWithCategory();

      @Query("SELECT count(pc.id) FROM ProductCopy pc JOIN pc.product p where p=:product")
      int getProductCopies(@Param("product") Product product);

      //Get the top book by Id
      Set<Book> findFirst6ByOrderByIdDesc();

      Set<Book> findFirst2ByOrderByDiscountDesc();

      Set<Book> findBookByCategory(Category category);


}
