package org.group5.model;

import org.group5.model.enums.Genre;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Pattern;

/**
 * Created by Bijay on 7/9/2016.
 */
@Entity
@PrimaryKeyJoinColumn(name="product_id")
public class Book extends Product {

    @NotBlank @Pattern(regexp = "[0-9]{3}-[0-9]{10}") //111-1234567890
    private String isbn;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}
