package com.revaturep0.models;

import jakarta.persistence.*;

import java.util.Objects;

/*
We'll make this class with some JPA annotations to tell Spring Data how we want the table to be built in the database
NOTE: We can use Spring data to construct our database tables automatically based off our java classes so we never
really have to run SQL to create them
 */

@Entity // Entity marks this class as one that needs to be created in the database
@Table(name = "users") // Table allows us to set any configuration details about the SQL table that we want
public class User {

    @Id
    @Column (name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    //constructor 1
    public User(){

    }
    //constructor 2
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //constructor 3
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //in bryan's code, he then overrides equals, hashcode, tostring. not necessary but may be useful.
}