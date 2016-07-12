package org.group5.model;

import org.group5.model.enums.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by Neha on 7/11/2016.
 */
@Entity
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Autowired
    @ManyToOne
    private Account account;

    private PaymentType type;

    public PaymentInfo(PaymentType type) {
        this.type=type;

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

}
