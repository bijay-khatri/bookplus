package org.group5.controller;

import org.group5.model.Book;
import org.group5.model.ProductCopy;
import org.group5.service.BookService;
import org.group5.service.ProductCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Example on 7/10/2016.
 */
@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ProductCopyService cartService;
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/productDetail/{id}", method = RequestMethod.GET)
    public String editCartQuantity(@PathVariable(value = "id") int id, Model model, HttpSession session) {
        //ProductCopy productCopy = cartService.findById(id);
        //long productId = productCopy.getProduct().getId();
        Set<ProductCopy> listOfProductCopy = cartService.getAll();
        int quantity = 0;
        Book book = bookService.findById(id);
        for(ProductCopy copy:listOfProductCopy){
            if(copy.getProduct().getId()==id){
                quantity+=1;
            }
        }


        //session.setAttribute("quant",quantity);
        System.out.println("============================");
        System.out.println(quantity);
        System.out.println("============================");
        Item item = new Item(id,quantity);
        model.addAttribute("item",item);
        model.addAttribute("book", book);
        //session.setAttribute("item1",item);
        return "/cart/add";
    }

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable(value = "id") int id,
                            @RequestParam("quantity") int quantity, Model model, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<>();
            cart.add(new Item(id,quantity));
            session.setAttribute("cart", cart);
            model.addAttribute("cart_quantity", cart.get(0).getQuantity());
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int flag = -1;
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getId() == id) {
                    flag = i;
                }
            }
            if (flag == -1) {
                cart.add(new Item(id,quantity));
            } else {
                cart.get(flag).setQuantity(cart.get(flag).getQuantity() + quantity);
            }
            session.setAttribute("cart", cart);


        }

        return "cart";
    }

    @RequestMapping(value = "/removeFromCart/{id}", method = RequestMethod.GET)
    public String removeFromCart(@PathVariable(value = "id") int id,
                                 Model model, HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int flag = -1;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == id) {
                cart.remove(i);
            }
        }
        session.setAttribute("cart", cart);
        return "cart";
    }

    public class Item {
        private int id;
        private int quantity;

        public Item(int id, int quantity) {
            this.id = id;
            this.quantity = quantity;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public int getQuantity() {
            return quantity;
        }

        public ProductCopy getProductCopy(int id) {
            return cartService.findById(id);
        }
    }
}
