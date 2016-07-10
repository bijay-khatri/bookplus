package org.group5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Bijay on 7/9/2016.
 */
@Entity
public class ProductCopy {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Product product;
}
