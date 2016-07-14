package org.group5.controller;

import org.group5.model.Book;
import org.group5.model.enums.Status;
import org.group5.service.BookService;
import org.group5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bijay on 7/9/2016.
 */
@Controller
@RequestMapping("/admin/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    private static String PATH = "/admin/book/";

    @RequestMapping(value={"","/","/all"})
    public String allBooks(Model model){
        model.addAttribute("books",bookService.getAll());
        return PATH + "list";
    }

    @RequestMapping(value="/add", method= RequestMethod.GET)
    public String addBook(@ModelAttribute Book book, HttpSession session, Model model){
        if(!loggedIn(session)) return "redirect:/admin";
        model.addAttribute("categories", categoryService.getAll());
        return "/admin/view/addBook";
    }

    private boolean loggedIn(HttpSession session) {
        return session.getAttribute("admin") != null;

    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String addBookSuccess(Model model, @Valid Book book, BindingResult result, RedirectAttributes redirect){
        String view = "redirect:" + "/admin/dashboard";

        //delegate uploads
       // String filename = Utility.uploadImage(file);
        //if(!filename.isEmpty())book.setImage(filename);

        if(result.hasErrors()){
            redirect.addFlashAttribute("message","Please correct the following errors.");
            model.addAttribute("categories", categoryService.getAll());
        }

        else {
            bookService.add(book);
            redirect.addFlashAttribute("message", "Book successfully added");
        }

        return view;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.delete(id);
        return "redirect:" + PATH + "all";
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable int id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("categories", categoryService.getAll());
        book.setQuantity(book.getProductCopies().size());
        model.addAttribute("book", book);
        return "/admin/view/addBook";
    }

    @ModelAttribute("allStatus")
    public List<Status> populateStatusTypes() {
        return Arrays.asList(Status.values());
    }
}
