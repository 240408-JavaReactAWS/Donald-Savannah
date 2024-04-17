package com.revaturep0.controllers;

import com.revaturep0.models.Pet;
import com.revaturep0.models.User;
import com.revaturep0.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/pets") // Controls where the requests are being sent to -> http://localhost:8080/users
public class PetController {

    private PetService ps;

    // Constructor
    @Autowired
    public PetController(PetService ps) {
        this.ps = ps;
    }

    // As a user, I can add a pet
    //@PostMapping(path = "/pets")
    @PostMapping
    public ResponseEntity<Pet> postPet(@RequestBody Pet pet){
        //return ps.postPet(pet);
        Pet returnedPet;
        try{
            returnedPet = this.ps.postPet(pet);
        }
        catch (Exception e) {
            return new ResponseEntity<Pet>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Pet>(returnedPet, OK);
    }


    // As a user, I can view all pets
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> allPets;
        try{
            allPets = this.ps.getAllPets();
        }
        catch (Exception e) {
            return new ResponseEntity<List<Pet>>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Pet>>(allPets, HttpStatus.OK);
    }
}