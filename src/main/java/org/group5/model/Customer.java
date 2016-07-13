package org.group5.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by Example on 7/11/2016.
 */
@Entity
@DiscriminatorValue("ROLE_USER")
public class Customer extends Person{
    @OneToOne
    private Order order;
    @OneToOne
    private Account account;

    @Column(name="user_deactivated")
    private boolean deactivated = false;

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

    public boolean isDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }
}
