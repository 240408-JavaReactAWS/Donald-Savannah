package com.revaturep0.models;

import jakarta.persistence.*;

import java.util.Objects;

/*
We'll make this class with some JPA annotations to tell Spring Data how we want the table to be built in the database
NOTE: We can use Spring data to construct our database tables automatically based off our java classes so we never
really have to run SQL to create them
 */

@Entity // Entity marks this class as one that needs to be created in the database
@Table(name = "pets") // Table allows us to set any configuration details about the SQL table that we want
public class Pet {

    @Id
    @Column (name = "petId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId_fk")
    private User user; //careful...make a fk


    @Column(unique = true, nullable = false)
    private String petName;

    @Column(nullable = false)
    private String species;


    //constructor 1
    public Pet(){

    }

    //const 2 -- only Id given (user id would be automatic, so incl here or no?)
    public Pet(String name){
        this.petName = name;
    }

    public Pet(int id, String name){
        this.id = id;
        this.petName = name;
    }

    public Pet(int id) {
        this.id = id;
    }

    public Pet(String species, int id, User user, String petName) {
        this.species = species;
        this.id = id;
        this.user = user;
        this.petName = petName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return this.petName;
    }

    public void setPetName(String name) {
        this.petName = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}