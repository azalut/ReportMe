package com.reportme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SomeEntity implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;

    public SomeEntity() {
    }

    public SomeEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SomeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
