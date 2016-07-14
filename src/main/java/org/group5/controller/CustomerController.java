package org.group5.controller;
import org.group5.model.Customer;
import org.group5.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
/**
 * Created by Ghanshyam on 7/3/2016.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    private static String PATH="/customer/";

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String getLogin(Model model){
        model.addAttribute("customer",new Customer());
        return "/user/login";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(String username, String password, HttpSession session, Model model, RedirectAttributes ra){
        Customer customer = customerService.getCustomer(username, password);
        // String view =  "redirect:"+PATH + "dashboard";

        String view ;
        if(customer==null){
            ra.addFlashAttribute("message","User name and password not correct.");
            view ="redirect:login";
        }
        else {
            session.setAttribute("username", customer.getFirstName());
            session.setAttribute("userId", customer.getId());
            addToSession(session, customer);
            view="redirect:/home";
        }
        return view;
    }

    /*
      Creates a new user
     */
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String register(@Valid Customer customer, String pass2, HttpSession session,
                           BindingResult result, RedirectAttributes redirect, Model model){
        String view =  "redirect:/home";
        if(result.hasErrors() || !pass2.equals(customer.getPassword())){
            redirect.addFlashAttribute("message","Please correct the following errors.");
            view =PATH + "login";
        }

        else {
            customerService.addCustomer(customer);
            redirect.addFlashAttribute("message",customer.getFirstName()+", \nWelcome to our family as a new Member");
            addToSession(session,customer);
        }

        return  view ;
    }


    @RequestMapping(value="/profile", method= RequestMethod.GET)
    public String getLogin(Model model, HttpSession session, RedirectAttributes redirect){
        String view =  PATH + "profile";
        model.addAttribute("customer",(Customer) session.getAttribute("customer"));
        return view;

    }

    @RequestMapping(value="/info", method= RequestMethod.GET)
    public String mypage(@ModelAttribute long id, Model model, RedirectAttributes redirect){
        Customer customer=customerService.findById(id);
        model.addAttribute("customer", customer);
        return PATH+"profile";
    }


    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String profleSetting(@PathVariable Long id, Model model){
        Customer customer=customerService.findById(id);
        model.addAttribute("customer", customer);
        return PATH+"edit";
    }

    @RequestMapping(value="/info", method= RequestMethod.POST)
    public String updateProfile(@Valid Customer customer, BindingResult result, RedirectAttributes redirect, Model model){
        String view = "redirect:"+ PATH + "dashboard/";
        if(result.hasErrors()){
            redirect.addFlashAttribute("message","Please correct the following errors.");

            view ="redirect:"+PATH+ "edit/"+customer.getId();
            return view;
        }

        else {
            customerService.addCustomer(customer);
            redirect.addFlashAttribute(customer.getFirstName()+", \nWelcome to our family as a new Member");
            model.addAttribute("customerId", customer.getId());
            view += customer.getId(); ;
        }
        return view;
    }
    @RequestMapping(value="/deactivate", method= RequestMethod.POST)
    public String deactivateProfile(HttpSession session){
        Customer customer = (Customer)session.getAttribute("customer");
        if(customer != null) {
            customer.setDeactivated(true);
            return "redirect:"+PATH + "logout";
        }
        else{
            return "redirect:" + PATH + "dashboard";
        }

    }

    @RequestMapping(value="/profile/{id}", method=RequestMethod.GET)
    public String getProfile(@PathVariable Long id, Model model){
        Customer customer=customerService.findById(id);
        model.addAttribute("customer", customer);
        return PATH+"profile";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String updateProfile(@Valid  Customer customer, BindingResult result, RedirectAttributes ra,
                                String pass1,String pass2, Model model){

        Customer cust=customerService.getCustomer(customer.getEmail(), customer.getPassword());
        if(!result.hasErrors()&&cust.getId() == customer.getId() &&
                pass1.equals(pass2)){
            customer.setPassword(pass1);
            customerService.add(customer);
            ra.addFlashAttribute("message","Your information has been updated.");
            model.addAttribute("message","Your information has been updated.");

            return "redirect:"+PATH+"/profile/"+customer.getId();
        }
        else{
            ra.addFlashAttribute("message","Some informations missing");
            model.addAttribute("message","Some informations missing");
            return "redirect:"+PATH+ "edit/"+customer.getId();
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirect){
        session.invalidate();
        redirect.addFlashAttribute("message","Bye bye!. See you again");
        return "redirect:/home";
    }


    /*
     * Sets the session if not already exists
     */

    private void addToSession(HttpSession session,Customer customer) {
        if(session.getAttribute("customer") == null)
            session.setAttribute("customer", customer);
    }

}