package com.revaturep0.repos;

import com.revaturep0.models.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDAO extends JpaRepository<Pet, Integer> {

    Pet findPetByPetName(String petName);
}