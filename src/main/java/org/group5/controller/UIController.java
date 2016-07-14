package org.group5.controller;

import org.group5.dao.CustomerDao;
import org.group5.model.Book;
import org.group5.model.Customer;
import org.group5.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Purevsuren-Mac on 7/11/16.
 */
@Controller
public class UIController {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    SearchService searchService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/home";
    }


    @RequestMapping("/home")
    public String home(HttpSession session, Model model){
        if(session.getAttribute("customer") != null){
            model.addAttribute("customer", session.getAttribute("customer"));
            model.addAttribute("cart_quantity",0);

        }
        return "index";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute Customer customer){
        return "user/login";
    }
    @RequestMapping("/category/{id}")
    public String productsByCategory(){

        return "main";
    }
    /*
      Search book by title, author and category
     */
    @RequestMapping(value="/search",method= RequestMethod.POST)
    public String searchResult(String searchKey, HttpSession session){
        List<Book> books =searchService.search(searchKey);
        if(books.size() >=1 && session.getAttribute("bookList") == null)
            session.setAttribute("bookList", books);

        if(books.size()==0) session.invalidate();

        return "redirect:/searchresult";

    }

    @RequestMapping(value="/searchresult",method= RequestMethod.GET)
    public String displayResult(HttpSession session,Model model){
        model.addAttribute("bookList",session.getAttribute("bookList"));
        model.addAttribute("search",true);
       return "index";

    }

}

