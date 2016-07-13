package org.group5.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.group5.model.Order;
import org.group5.model.OrderLine;
import org.group5.restcontroller.MailSubmissionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by Neha on 7/12/2016.
 */
@Aspect
@Component
public class EmailAdvice {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    MailSubmissionController mailController;

    @After("execution(* org.group5.service.OrderService.add(..))&&args(order)")
    public void sendConfirmationEmail(JoinPoint joinpoint, Order order) throws Throwable {
        System.out.println("after execution of method " + joinpoint.getSignature().getName());

        System.out.println("Hello " + order.getOrderDate());
        long id = order.getId();
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println(message.getReplyTo());

        StringBuffer sb = new StringBuffer();
        sb.append("Product Name:  ");
        sb.append("\t");
        sb.append("Quantity:  ");
        sb.append("\t");
        sb.append("Price:  ");
        sb.append("\t");
        sb.append("Expected Delivery Date:  ");
        for (OrderLine item : order.getOrderLineItems()) {
            sb.append("\n\n");
            sb.append(item.getProduct().getName());
            sb.append("\t");

            sb.append(item.getQuantity());
            sb.append("\t");

            sb.append(item.getPrice());
            sb.append("\t");

            sb.append(item.getDeliveryDate());
            sb.append("\n");
        }
        message.setText("Thankyou for shopping   " + "\n\n" +
                "Your Order Details are  : \n" + sb + "\n\n" +
                "Total Order Price :  " + order.getTotalOrderPrice());
        message = mailController.send(message);

        System.out.println(" Email sent successfully " + message);

    }


}
