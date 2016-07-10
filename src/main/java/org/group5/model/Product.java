package org.group5.model;

import org.group5.model.enums.Status;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bijay on 7/9/2016.
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Product {

    @Id @GeneratedValue
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty @Lob
    private String description;

    @Lob
    private byte[] image;

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



}
