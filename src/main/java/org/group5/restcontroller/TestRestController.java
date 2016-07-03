package org.group5.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bijay on 7/3/2016.
 */
@RestController
public class TestRestController {

    @RequestMapping("/api/test/all")
    public String getAll(){
        return "all";
    }
}
