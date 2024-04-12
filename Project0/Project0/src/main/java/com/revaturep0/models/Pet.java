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
    @Column (name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    //what annotation?
    private int userId; //careful...make a fk

    //constructor 1
    public Pet(){

    }

    //const 2 -- only Id given (user id would be automatic, so incl here or no?)
    public Pet(String name){
        this.name = name;
    }

    public Pet(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Pet(int id, String name, String species, int userId){
        this.id = id;
        this.name = name;
        this.species = species;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}