package org.group5.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by Bijay on 7/9/2016.
 */
@PrimaryKeyJoinColumn(name = "person_id")
@Entity
public class Author extends Person {

    @NotEmpty
    public String experience_level;
}
