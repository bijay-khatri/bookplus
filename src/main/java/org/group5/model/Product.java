package org.group5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.group5.model.enums.Status;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
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

    @Lob
    private byte[] image;

    @DecimalMin(value = "0")
    private Double price;

    @DecimalMin(value = "0", message = "Minimum discount should be at least 0.0")
    @DecimalMax(value = "100", message = "Maximum discount should be at most 100.0")
    private Double discount;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private List<ProductCopy> productCopies = new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @NotNull
    @JsonIgnore
    private Category category;

    @Transient
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

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
        //prevent endless loop
        if(sameAsFormer(category)) return;

        if(category !=null)
            category.addProduct(this);

        Category temp = this.category;
        this.category = category;

        if(temp !=null){
            temp.removeProduct(this);
        }
    }

    public void removeCategory(Category category){
        this.category = null;
        category.removeProduct(this);
    }

    public void addProductCopy(ProductCopy copy){
        copy.setProduct(this);
        this.productCopies.add(copy);
    }

    private boolean sameAsFormer(Category newCategory) {
        return category==null? newCategory == null : category.equals(newCategory);
    }

}
