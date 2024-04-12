package com.revaturep0.controllers;

import com.revaturep0.models.Pet;
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

    @Autowired
    public PetController(PetService ps) {
        this.ps = ps;
    }

    @PostMapping(path = "/pets")
    private Pet PostPet(@RequestBody Pet pet){
        return ps.postPet(pet);
    }

}