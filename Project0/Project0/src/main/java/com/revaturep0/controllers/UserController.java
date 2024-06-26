package com.revaturep0.controllers;

import com.revaturep0.models.User;
import com.revaturep0.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users") // Controls where the requests are being sent to -> http://localhost:8080/users
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class UserController {

    private UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUserAccounts() {
        List<User> returnedUsers;
        try{
            returnedUsers = this.us.getAllUsers();
        }
        catch (Exception e) {
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(returnedUsers, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<User> getUserByIdHandler(@PathVariable int id) {
        User user;
        try {
            user = this.us.findUserById(id);
        }
        catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND); // returns 404
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<User> createUserHandler(@RequestBody User petOwner) {

        User user;
        try {
            user = this.us.createUserAccount(petOwner);
        }
        catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @PostMapping({"/login"})
    public ResponseEntity<User> userLoginHandler(@RequestBody User user) {
        User returnedUser;
        try {
            returnedUser = this.us.findUserByUsernameAndPass(user.getUsername(), user.getPassword());
        }
        catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<User>(returnedUser, HttpStatus.OK);
    }
}