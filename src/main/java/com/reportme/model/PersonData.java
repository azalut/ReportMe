package com.reportme.model;

import javax.persistence.Embeddable;

@Embeddable
public class PersonData {
    private String nickname;
    private String password;

    private String name;
    private String lastname;
    private String email;

    public PersonData() {
    }

    public PersonData(String nickname, String password, String name, String lastname, String email) {
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
