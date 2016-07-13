package org.group5.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Purevsuren-Mac on 7/11/16.
 */
@Controller
public class UIController {

    @RequestMapping("/")
    public String index(){
        return "redirect:/home";
    }


    @RequestMapping("/home")
    public String home(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

}

