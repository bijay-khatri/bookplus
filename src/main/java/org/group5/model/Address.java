package org.group5.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Embeddable;

/**
 * Created by Bijay on 7/9/2016.
 */
@Embeddable
public class Address {

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotEmpty
    @Range(min = 1, max = 999999)
    private int zip;
}
