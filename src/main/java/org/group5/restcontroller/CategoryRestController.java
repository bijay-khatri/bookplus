package org.group5.restcontroller;

import org.group5.model.Category;
import org.group5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by Bijay on 7/11/2016.
 */
@RestController
@RequestMapping("/api/category/")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    /**********GET All Categories *************/
    @RequestMapping("all")
    public Set<Category> findAllCategories() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(10);
        return categoryService.getAll();
    }
//
//    /**********GET ALL BOOKS By CategoryId *************/
//    @RequestMapping("category/{category}")
//    public Set<Book> findAllBooksInCateory(@PathVariable String category){
//        return bookService.getAll();
//    }
//
//    @RequestMapping("{id}")
//    public Book findSingleBook(@PathVariable int id){
//        return bookService.findById(id);
//    }
//
    @RequestMapping("delete/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.delete(id);
    }
//
//    @RequestMapping("copy/{id}")
//    public void getProductCopy(@PathVariable int id){
//        bookService.findById(id);
//    }
}
