package org.group5.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by Bijay on 7/9/2016.
 */

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Person {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String LastName;

    @Embedded
    private Address address;
}
