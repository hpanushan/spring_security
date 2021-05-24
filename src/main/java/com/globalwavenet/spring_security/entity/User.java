package com.globalwavenet.spring_security.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "flink")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
}
