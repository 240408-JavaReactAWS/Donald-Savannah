package com.revaturep0.controllers;

import com.revaturep0.models.User;
import com.revaturep0.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users") // Controls where the requests are being sent to -> http://localhost:8080/users
public class UserController {

    private UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }
    //SAVANNAH'S CODE HERE: USER CAN CREATE NEW ITEM AND VIEW ALL ITEMS

    //will do this in pet controller for now
    /*
    will be something like this...

    @PostMapping(path = "/messages")
    private Message PostMessage(@RequestBody Message message){
        return messageService.postMessage(message);
    }

    @GetMapping(path = "/messages")
    public List<Message> findAllMessages() {
        System.out.println("in controller find messages");
        return messageService.findAllMessages();
        }
     */

    //DONALD'S CODE HERE FOR CREATE ACCOUNT AND LOG IN
    @GetMapping("{id}")
    public ResponseEntity<User> getUserByIdHandler(@PathVariable int id) {
        User user;
        try {
            user = this.us.findUserById(id);
        }
        catch (Exception e) {
            return new ResponseEntity<User>(NOT_FOUND); // returns 404
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
        return new ResponseEntity<User>(user, HttpStatus.OK);

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