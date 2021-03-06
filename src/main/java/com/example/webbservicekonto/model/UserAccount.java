package com.example.webbservicekonto.model;

import javax.persistence.*;

@Entity(name = "UserAccount")
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String email;
    private String password;

    public UserAccount() {
    }

    public UserAccount(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() { return email;}

    public String getPassword() { return password;}

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) { this.id = id;}

    public void setEmail(String email) { this.email = email;}

    public void setPassword(String password) { this.password = password;}

    @Override
    public String toString() {
        return this.name;
    }
}
