package com.example.Noble.JournalServer.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);



    @Query("SELECT emailAddress FROM User u WHERE u.emailAddress = :emailAddress")
    String findByEmail(@Param("emailAddress") String email);

    @Query("SELECT u FROM User u WHERE u.emailAddress = :emailAddress")
    User findUserByEmail(@Param("emailAddress") String email);
}
