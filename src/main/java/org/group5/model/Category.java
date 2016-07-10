package org.group5.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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

    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<Product> products = new HashSet<>();


}
