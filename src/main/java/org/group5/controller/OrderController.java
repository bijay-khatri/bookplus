package org.group5.controller;

import org.group5.service.OrderService;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.group5.model.Order;
import org.group5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Neha on 7/10/2016.
 */
@Controller
public class OrderController {

    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public ModelAndView retrieveOrderDetails(@PathVariable("orderId") long orderId){
       ModelAndView mav = new ModelAndView("order");
      /*  Order order = this.bookService.findOrder(orderId);

        Hibernate.initialize(order);
        if (order instanceof HibernateProxy) {
            order = (Order) ((HibernateProxy) order).getHibernateLazyInitializer().getImplementation();
        }
        mav.addObject("order", order);*/
        return mav;
    }
    @RequestMapping(value = "admin/orders")
    public String allOrders(Model model){
        model.addAttribute("OrderDetail",orderService.getAll());
        return "/admin/view/orders";
    }

}
