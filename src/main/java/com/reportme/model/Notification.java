package com.reportme.model;

import com.reportme.model.person.Person;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Notification implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    @ManyToOne
    private Person notifier;

    @Enumerated(value = EnumType.STRING)
    private NotificationStatus notificationStatus;

    public Notification() {
    }

    public Notification(String title, String description, Person notifier, NotificationStatus notificationStatus) {
        this.title = title;
        this.description = description;
        this.notifier = notifier;
        this.notificationStatus = notificationStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getNotifier() {
        return notifier;
    }

    public void setNotifier(Person notifier) {
        this.notifier = notifier;
    }

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }
}
