package org.group5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bijay on 7/12/2016.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String home(){
        return "index";
    }
}
