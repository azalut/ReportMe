package com.reportme.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Administrator extends Person implements Serializable {
    @OneToMany
    private List<Group> createdGroups = new ArrayList<>();

    public Administrator() {
    }

    public Administrator(PersonData personData, boolean enabled, Set<Role> roleSet, Address address) {
        super(personData, enabled, roleSet, address);
    }

    public List<Group> getCreatedGroups() {
        return createdGroups;
    }

    public void setCreatedGroups(List<Group> createdGroups) {
        this.createdGroups = createdGroups;
    }
}
