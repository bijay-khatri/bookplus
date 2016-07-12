package org.group5.restcontroller;

import org.group5.model.Book;
import org.group5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by Bijay on 7/11/2016.
 */
@RestController
@RequestMapping("/api/book/")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @RequestMapping("all")
    public Set<Book> findAllBooks(){
        return bookService.getAll();
    }

    @RequestMapping("delete/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.delete(id);
    }
}
