package com.example.Noble.JournalServer.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
//this annotation tells spring that this class is the service layer
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Autowired
    public Iterable<User> getUsers() {
//This little bastard does a select* without any damn SQL!!
        return userRepo.findAll();

    }

    public User findByUsername(String username){

        return userRepo.getUserByUsername(username);
    }

    public void addUser(User user) {
        userRepo.save(user);
        System.out.println(user);
    }

    public void deleteUser(Long id) {
        boolean exists = userRepo.existsById(id);
        if (!exists) {

            throw new IllegalStateException("entry doesn't exist");
        } else {
            userRepo.deleteById(id);
        }
    }

    @Transactional
    public void updateUser(Long id,
                           String userName,
                           String password) {
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalStateException(
                "user with id " + id + " doesn't exist"
        ));

        //Updating username

        if (user.getUsername() != null && userName.length() > 0 && !Objects.equals(user.getUsername(), user)) {

            user.setUsername(userName);
        }
        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {

            user.setPassword(password);
        }


    }

}

