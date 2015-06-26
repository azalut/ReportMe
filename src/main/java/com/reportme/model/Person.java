package com.reportme.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
public abstract class Person implements Serializable {
    @Id
    @GeneratedValue
    protected int id;
    @Embedded
    protected PersonData personData;
    protected boolean enabled;

    @OneToMany
    protected List<Notification> myNotifications = Collections.<Notification>emptyList();
    @ElementCollection(targetClass = Role.class)
    @Enumerated(value = EnumType.STRING)
    protected Set<Role> roleSet;
    @Embedded
    protected Address address;

    public Person() {
    }

    public Person(PersonData personData, boolean enabled, Set<Role> roleSet, Address address) {
        this.personData = personData;
        this.enabled = enabled;
        this.roleSet = roleSet;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonData getPersonData() {
        return personData;
    }

    public void setPersonData(PersonData personData) {
        this.personData = personData;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Notification> getMyNotifications() {
        return myNotifications;
    }

    public void setMyNotifications(List<Notification> myNotifications) {
        this.myNotifications = myNotifications;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
