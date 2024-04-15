package com.revaturep0.services;

import com.revaturep0.models.Pet;
import com.revaturep0.models.User;
import com.revaturep0.repos.PetDAO;
import com.revaturep0.repos.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PetService {

    private PetDAO pd;
    // private UserDAO ud;

    public PetService(PetDAO pd){
        this.pd = pd;
    }

    //"As a user, I can create a new item"
    //note: use post instead of create??
    @Autowired
    public Pet postPet(Pet pet) throws ResponseStatusException {
//        return pd.save(pet); //?? should extend users??
        return null; //temporary
    }

    //"As a user, I can view all items"
    public List<Pet> getAllPets(){
        return pd.findAll();
    }
}