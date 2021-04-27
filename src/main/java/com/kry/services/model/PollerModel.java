package com.kry.services.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Handles the services table
 */
@Entity
@Table(name = "services")
public class PollerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "url")
    public String url;

    @Column(name = "status")
    public String status; //TODO this should be an Enum

    @Column(name = "last_change")
    public Date lastChange;

    public PollerModel() {

    }

    public PollerModel(String name, String url, String status, Date lastChange) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.status = status;
        this.lastChange = lastChange;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}
