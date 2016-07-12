package org.group5.model;

import javax.persistence.*;

/**
 * Created by Bijay on 7/9/2016.
 */
@Entity
public class ProductCopy {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade= CascadeType.ALL)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCopy that = (ProductCopy) o;

        if (id != that.id) return false;
        return product != null ? product.equals(that.product) : that.product == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
