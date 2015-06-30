package com.reportme.model.person;

import com.reportme.model.Group;

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

    public Administrator(PersonData personData, String username, String password, boolean enabled, Set<Role> roleSet, Address address) {
        super(personData, username, password, enabled, roleSet, address);
    }

    public List<Group> getCreatedGroups() {
        return createdGroups;
    }

    public void setCreatedGroups(List<Group> createdGroups) {
        this.createdGroups = createdGroups;
    }
}
