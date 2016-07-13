package org.group5.controller;

import org.group5.model.Category;
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

import javax.validation.Valid;

/**
 * Created by Rishi on 7/10/2016.
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private static String PATH="/admin/category/";

    @RequestMapping(value="/all")
    public String allCategory(Model model){
        model.addAttribute("categories",categoryService.getAll());
        return PATH+"list";
    }

    @RequestMapping(value = "/add" ,method= RequestMethod.GET)
    public  String addCategory(@ModelAttribute Category category){
        return "/admin/view/addCategory";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addCategorySuccess(@Valid Category category, BindingResult result, RedirectAttributes redirect){
       String view="redirect:/admin/category";
        if(result.hasErrors()){
            redirect.addFlashAttribute("message","please put correct information");
        }
        else{
            categoryService.add(category);
            redirect.addFlashAttribute("message","Category successfully added");
        }
        return view;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String editCategory(@PathVariable int id, Model model){
        Category category= categoryService.findBy(id);
        model.addAttribute("category",category);
        return "/admin/view/addCategory";
    }

    @RequestMapping(value="/delete/{id}")
    public String deleteCategory(@PathVariable int  id){
        System.out.println(id);
        categoryService.delete(id);
        return "redirect:"+PATH+"all";

    }


}
