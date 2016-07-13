package org.group5.controller;

import org.group5.model.Admin;
import org.group5.service.AdminService;
import org.group5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

    @RequestMapping(value="/apply")
    public String registerPage(@ModelAttribute Admin admin, Model model){
        if(!model.containsAttribute("admin"))
            model.addAttribute("admin", new Admin());
        return PATH + "register";
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


    /**************For Admin as App User ***********/

    @Autowired
    public AdminService adminService;

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(String email, String password, Model model, HttpSession session, RedirectAttributes redirect){
        Admin admin = adminService.checkAdmin(email,password);

        String view =  "redirect:"+PATH + "dashboard";
        if(admin == null)
        {
            redirect.addFlashAttribute("message","Please correct the following errors.");
            view ="redirect:"+PATH + "login";
        }
        else {
            if(session.getAttribute("admin") == null)
                session.setAttribute("admin",admin);
            redirect.addFlashAttribute("message", admin.getFirstName()+", \nWelcome Back!!");
        }
        return view;
    }

    @RequestMapping(value="/preregister", method= RequestMethod.POST)
    public String getPending(@Valid Admin admin, HttpSession session, RedirectAttributes redirect){
        adminService.add(admin);
        redirect.addFlashAttribute("message","Please wait for activation before using app");
        if(session.getAttribute("admin") == null)
            session.setAttribute("admin",admin);
        return "redirect:" + PATH  +"dashboard";
    }

    @RequestMapping("/all")
    public String getAllAdmin(Model model, HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        model.addAttribute("currentAdmin", admin);
        model.addAttribute("admins",adminService.getAll());
        return PATH + "list";
    }


    @RequestMapping("/edit/{id}")
    public String enableAdmin(@PathVariable long id){
        Admin admin = adminService.findById(id);
        admin.setEnabled(true);
        adminService.add(admin);
        return "redirect:" + PATH + "all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable long id){
        adminService.delete(id);
        return "redirect:" + PATH + "all";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirect){
        session.invalidate();
        redirect.addFlashAttribute("message","Bye bye!. See you again");
        return "redirect:" + PATH;
    }

}
