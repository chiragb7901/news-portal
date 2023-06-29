package com.s2p.dto;

import javax.persistence.Column;

public class UserDTO {
    private long id;
    private String email;
    private String userpassword;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }

    public UserDTO(long id, String email, String userpassword) {
        this.id = id;
        this.email = email;
        this.userpassword = userpassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public UserDTO() {
    }
}
