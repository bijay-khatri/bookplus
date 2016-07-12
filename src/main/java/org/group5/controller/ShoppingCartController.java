package org.group5.controller;

import org.group5.model.ProductCopy;
import org.group5.service.BookService;
import org.group5.service.ProductCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Example on 7/10/2016.
 */
@Controller
@RequestMapping("/ShoppingCart")
public class ShoppingCartController {
    @Autowired
    private ProductCopyService cartService;
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/addToCart/{id}", method= RequestMethod.GET)
    public String addToCart(@PathVariable(value = "id") int id,
                            Model model, HttpSession session){
        if(session.getAttribute("cart")==null){
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(id,1));
            session.setAttribute("cart",cart);
        }else{
            List<Item> cart = (List<Item>)session.getAttribute("cart");
            int flag=-1;
            for(int i=0;i<cart.size();i++){
                if(cart.get(i).getId()==id) {
                    flag = i;
                }
            }
             if(flag==-1) {
                 cart.add(new Item(id,1));
             }
            else{
                 cart.get(flag).setQuantity(cart.get(flag).getQuantity()+1);
             }
            session.setAttribute("cart",cart);

        }
        return "cart";
    }
    @RequestMapping(value = "/removeFromCart/{id}", method= RequestMethod.GET)
    public String removeFromCart(@PathVariable(value = "id") int id,
                       Model model, HttpSession session){
        List<Item> cart = (List<Item>)session.getAttribute("cart");
        int flag=-1;
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).getId()==id) {
                cart.remove(i);
            }
        }
        session.setAttribute("cart",cart);
        return "cart";
    }

    public class Item{
        private int id;
        private int quantity;
        public Item(int id,int quantity){
            this.id= id;
            this.quantity = quantity;
        }
        public void setId(int id){
            this.id  = id;
        }
        public void setQuantity(int quantity){
            this.quantity = quantity;
        }
        public int getId(){
            return id;
        }
        public int getQuantity(){
            return quantity;
        }
        public ProductCopy getProductCopy(int id){
            return cartService.findById(id);
        }
    }
}
