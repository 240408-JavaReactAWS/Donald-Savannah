package com.revaturep0.repos;

import com.revaturep0.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

}