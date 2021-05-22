package com.globalwavenet.spring_security.entity;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "flink")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "email")
    private String userName;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "active")
    private Boolean active;

    public User() {
    }

    public User(int id, String userName, String fname, String lname, String password, String role, Boolean active) {
        this.id = id;
        this.userName = userName;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
