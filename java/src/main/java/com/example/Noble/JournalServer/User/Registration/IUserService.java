package com.example.Noble.JournalServer.User.Registration;

import com.example.Noble.JournalServer.User.User;
import com.example.Noble.JournalServer.User.UserAlreadyExistException;

public interface IUserService {
    User registerNewUserAccount(UserDTO userDto) throws UserAlreadyExistException;
}