package org.group5.model;

import org.group5.model.enums.Status;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bijay on 7/9/2016.
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Product {

    @Id @GeneratedValue
    private long id;

    @NotEmpty(message = "Product name may not be empty")
    private String name;

    @Lob @NotEmpty(message="Description may not be empty")
    private String description;

   // @Lob
   // private byte[] image;

    @DecimalMin(value = "0")
    private Double price;

    @DecimalMin(value = "0")
    private Double discount;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductCopy> productCopies = new ArrayList<>();

    @ManyToOne
    private Category category;
    public Product(){}

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

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

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ProductCopy> getProductCopies() {
        return Collections.unmodifiableList(productCopies);
    }

    private void setProductCopies(List<ProductCopy> productCopies) {
        this.productCopies = productCopies;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addProductCopy(ProductCopy copy){
        copy.setProduct(this);
        this.productCopies.add(copy);
    }

}
