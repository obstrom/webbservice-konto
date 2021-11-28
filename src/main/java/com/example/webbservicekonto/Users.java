package com.example.webbservicekonto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long email;
    private long password;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getEmail() { return email;}

    public long getPassword() { return password;}

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) { this.id = id;}

    public void setEmail(long email) { this.email = email;}

    public void setPassword(long password) { this.password = password;}

    @Override
    public String toString() {
        return this.name;
    }
}
