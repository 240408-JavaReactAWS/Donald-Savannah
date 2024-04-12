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
}