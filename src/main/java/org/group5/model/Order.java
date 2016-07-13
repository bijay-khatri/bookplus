package org.group5.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Neha on 7/10/2016.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Address shippingAddress;
    @ManyToOne(optional = false)
    private Account account;

    private Date orderDate;
    // private Date deliveryDate;

    private Double totalOrderPrice = null;

    @JoinColumn(name = "order_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OrderLine> orderLineItems = new ArrayList<OrderLine>();

    public Order() {

    }


    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Long getId() {
        return this.id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    public List<OrderLine> getOrderLineItems() {
        return this.orderLineItems;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

   /* public Date getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }*/

    public Double getTotalOrderPrice() {
        return this.totalOrderPrice;
    }

    public int getTotalNumberOfProducts() {
        int total = 0;
        for (OrderLine orderLine : getOrderLineItems()) {
            total += orderLine.getQuantity();
        }
        return total;
    }

    public void addOrderLineItem(OrderLine orderLine) {
        if (this.orderLineItems.add(orderLine)) {
            if (this.totalOrderPrice == null) {
                this.totalOrderPrice = orderLine.getPrice();
            } else {
                this.totalOrderPrice = (this.totalOrderPrice) + (orderLine.getPrice());
            }
        }
    }

    //Update functionality also
    public void updateOrderLineItems() {

    }


}
