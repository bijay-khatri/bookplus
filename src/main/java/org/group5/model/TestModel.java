package org.group5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by Bijay on 7/3/2016.
 */
@Entity(name="test")
public class TestModel {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Lob
    private byte[] cover;

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
