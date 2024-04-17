package com.revaturep0.repos;

import com.revaturep0.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("From User WHERE username = :usernameVar")
    User findUserByUsername(@Param("usernameVar") String username);

    @Query("From User WHERE username = :usernameVar AND password = :passwordVar")
    User findByUsernameAndPassword(@Param("usernameVar") String username, @Param("passwordVar") String password);

}