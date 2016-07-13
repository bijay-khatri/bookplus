package org.group5.controller;
import org.group5.dao.CustomerDao;
import org.group5.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Purevsuren-Mac on 7/11/16.
 */
@Controller
public class UIController {
    @Autowired
    private CustomerDao customerDao;
    @RequestMapping("/")
    public String index(){
        return "redirect:/home";
    }


    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute Customer customer){
        return "user/login";
    }

}

