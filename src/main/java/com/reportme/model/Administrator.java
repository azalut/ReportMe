package com.reportme.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Administrator extends Person implements Serializable {
    @OneToMany
    private List<Group> createdGroups;

    public Administrator() {
    }

    public Administrator(PersonData personData, boolean enabled, Set<Role> roleSet, Address address, List<Group> createdGroups) {
        super(personData, enabled, roleSet, address);
        this.createdGroups = createdGroups;
    }

    public List<Group> getCreatedGroups() {
        return createdGroups;
    }

    public void setCreatedGroups(List<Group> createdGroups) {
        this.createdGroups = createdGroups;
    }
}
