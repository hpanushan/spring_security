package com.globalwavenet.spring_security.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

public class UserGetResponse {

    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String fname;
    private String lname;
    private String role;
    private Boolean active;

    public UserGetResponse() {
    }

    public UserGetResponse(int id, String userName, String fname, String lname, String role, Boolean active) {
        this.id = id;
        this.userName = userName;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
