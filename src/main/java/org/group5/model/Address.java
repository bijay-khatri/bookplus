package org.group5.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Embeddable;

/**
 * Created by Bijay on 7/9/2016.
 */
@Embeddable
public class Address {

   // @NotBlank
    private String street;

   // @NotBlank
    private String city;

   // @NotBlank
    private String state;

   // @NotEmpty
   // @Range(min = 1, max = 999999)
    /*@Value("15220")
    private int zip;*/

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /*public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }*/
}
