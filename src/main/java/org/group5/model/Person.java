package org.group5.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Bijay on 7/9/2016.
 */

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role")
@Entity
@Table(name="USER")
public abstract class Person {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;


    @Embedded
    private Address address;
    @NotNull
    @Length(min=5, max=40)
    String email;
    @NotNull
    @Length(min=8, max=40)
    String password;

    public Person(){

    }

    public Person(String firstName, String lastName, Address address,
                  String email, String password
                  ){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Person(String email, String password){
        this.email = email;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
