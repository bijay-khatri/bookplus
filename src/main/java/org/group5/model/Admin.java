package org.group5.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Created by Ghanshyam on 7/11/2016.
 */
@Entity
@DiscriminatorValue("ROLE_ADMIN")
public class Admin extends Person {

    private boolean enabled = false;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Admin(String firstName, String lastName, Address address, String email, String password) {
        super(firstName, lastName, address, email,password);
    }

    public Admin(String email, String password) {
        super(email,password);
    }

    public Admin() {
        super();
    }

}