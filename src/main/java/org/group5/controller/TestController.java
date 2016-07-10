package org.group5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bijay on 7/3/2016.
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        return "index";
    }

    @RequestMapping("/test/**")
    public String anything(){
        return "redirect:/";
    }
}
