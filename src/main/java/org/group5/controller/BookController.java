package org.group5.controller;

import org.group5.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bijay on 7/9/2016.
 */
@Controller
@RequestMapping("/admin/book")
public class BookController {

    @RequestMapping("/add")
    public String addBook(@ModelAttribute Book book){
        return "admin/book/add";
    }
}
