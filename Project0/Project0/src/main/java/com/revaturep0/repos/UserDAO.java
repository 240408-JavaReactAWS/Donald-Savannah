package com.revaturep0.repos;

import com.revaturep0.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("From User WHERE username = :usernameVar")
    User findUserByUsername(@Para("usernameVar") String username);

    @Query("From User WHERE username = :usernameVar AND password = :password")
    User findByUsernameAndPassword(@Param("usernameVar") String username, @Param("passwordVar") String password);

}