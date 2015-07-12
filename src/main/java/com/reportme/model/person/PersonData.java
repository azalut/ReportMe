package com.reportme.model.person;

import com.reportme.model.validation.UsernameAvailable;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class PersonData {
    @NotNull
    @Size(min = 2, max = 40)
    private String name;
    @NotNull
    @Size(min = 2, max = 40)
    private String lastname;
    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 40)
    @UsernameAvailable
    private String username;
    @NotNull
    @Size(min = 6, max = 40)
    private String password;
    @NotNull
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
