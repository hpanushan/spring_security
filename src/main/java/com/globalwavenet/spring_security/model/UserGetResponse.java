package com.globalwavenet.spring_security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserGetResponse {

    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String fname;
    private String lname;
    private String role;
    private Boolean active;
}
