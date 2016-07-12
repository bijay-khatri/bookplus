package org.group5.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by Example on 7/11/2016.
 */
@Entity
public class Customer extends Person{

    @OneToOne
    private Order order;
    @OneToOne
    private Account account;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer(){

    }
}
