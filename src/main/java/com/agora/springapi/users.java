package com.agora.springapi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class users {

    @Id
    private String uname; // Assuming the username is unique and can serve as the ID
    private String password;

    // Constructors, getters, and setters
    public users() {
    }

    public users(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}