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

    public ProductCopy() {
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
