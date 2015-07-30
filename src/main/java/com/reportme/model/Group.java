package com.reportme.model;

import com.reportme.model.validation.GroupNameAvailable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groupp")
public class Group implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Size(min = 6, max = 40)
    @GroupNameAvailable
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Notification> notificationList = new ArrayList<>();

    public Group() {
    }

    public Group(String groupName) {
        this.name = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }
}
