package org.group5.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bijay on 7/9/2016.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty @Lob
    private String description;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="category",cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>(0);


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }

    private void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        //product.setCategory(this);
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category(){}
}
