package com.example.Noble.JournalServer.User.Registration;

import com.example.Noble.JournalServer.User.MyUserDetails;
import com.example.Noble.JournalServer.User.User;
import com.example.Noble.JournalServer.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepo.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

    //EmailAddress is the unique identifier. So I will be searching for that in the DB instead of username.
    public UserDTO loadUserByEmail(String email)
            throws UserNotFoundException {
        User user = userRepo.findUserByEmail(email);

            if (user == null) {
                throw new UserNotFoundException("Could not find user");
            }

            return new UserDTO(user);

        }

    }

