package com.revaturep0.services;

import com.revaturep0.models.User;
import com.revaturep0.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {


    private UserDAO this.userDAO;


    @Autowired
    UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public User createUserAccount(User user) {
        return this.userDAO.save(user);
    }

    public List<User> getAllUsers() {
        return this.userDAO.findAll();
    }


    public User findUserById(int id) {
        return this.userDAO.findById(id).orElseThrow(() -> UserNotFoundException("No user found by id" + id));
    }


    public User findUserByUsernameAndPass(String username, String password) {
        return this.userDAO.findByUsernameAndPassword(username, password);
    }
}