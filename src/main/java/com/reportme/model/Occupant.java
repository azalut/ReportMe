package com.reportme.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Occupant extends Person implements Serializable {
    @OneToMany
    private List<Group> myGroups = new ArrayList<>();

    public Occupant() {
    }

    public Occupant(PersonData personData, boolean enabled, Set<Role> roleSet, Address address) {
        super(personData, enabled, roleSet, address);
    }

    public List<Group> getMyGroups() {
        return myGroups;
    }

    public void setMyGroups(List<Group> myGroups) {
        this.myGroups = myGroups;
    }
}
