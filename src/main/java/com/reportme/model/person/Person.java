package com.reportme.model.person;

import com.reportme.model.Group;
import com.reportme.model.Notification;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Valid
    @Embedded
    private PersonData personData;
    @Valid
    @Embedded
    private Address address;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roleSet = new HashSet<>();

    @OneToMany
    private List<Notification> myNotifications = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Person_myGroups")
    private Set<Group> myGroups = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Person_belongToGroups")
    private Set<Group> belongToGroups = new HashSet<>();


    public Person() {
    }

    public Person(PersonData personData, Set<Role> roleSet, Address address) {
        this.personData = personData;
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

    public Set<Group> getMyGroups() {
        return myGroups;
    }

    public void setMyGroups(Set<Group> myGroups) {
        this.myGroups = myGroups;
    }

    public Set<Group> getBelongToGroups() {
        return belongToGroups;
    }

    public void setBelongToGroups(Set<Group> belongToGroups) {
        this.belongToGroups = belongToGroups;
    }
}
