package com.reportme.model.person;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
    @NotNull
    @Size(min = 2, max = 40)
    private String street;
    @NotNull
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String postCode;
    @NotNull
    @Size(min = 2, max = 40)
    private String city;

    public Address() {
    }

    public Address(String street, String postCode, String city) {
        this.street = street;
        this.postCode = postCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
