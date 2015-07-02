package com.reportme.model.person;

import javax.persistence.Embeddable;

@Embeddable
public class PersonData {
    private String name;
    private String lastname;
    private String email;

    private String username;
    private String password;
    private boolean enabled;

    public PersonData() {
    }

    public PersonData(String name, String lastname, String email, String username, String password, boolean enabled) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
