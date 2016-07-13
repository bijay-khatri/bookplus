package org.group5.controller;

import org.group5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Purevsuren-Mac on 7/12/16.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookService bookService;

    private static String PATH = "/admin/";

    @RequestMapping(value={"","/"})
    public String allBooks(Model model){
        return PATH +"index";
    }
    @RequestMapping(value="/user/apply")
    public String registerPage(){
        return PATH + "user/register";
    }

    @RequestMapping(value = {"/dashboard"})
    public String dashboard(Model model){
        model.addAttribute("books", bookService.getAll());
        return PATH + "view/main";
    }
    @RequestMapping(value = {"/category"})
    public String category(){
        return PATH + "view/category";
    }

}
