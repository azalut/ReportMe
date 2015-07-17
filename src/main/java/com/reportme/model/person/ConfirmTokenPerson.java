package com.reportme.model.person;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "confirmPersonToken")
public class ConfirmTokenPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String token;
    @OneToOne
    @JoinColumn(name = "personId")
    private Person person;

    public ConfirmTokenPerson() {
    }

    public ConfirmTokenPerson(String token, Person person) {
        this.token = token;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
