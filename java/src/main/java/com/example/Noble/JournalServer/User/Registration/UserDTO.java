package com.example.Noble.JournalServer.User.Registration;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@PasswordMatches
public class UserDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String emailAddress;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String confirmEmail;

    @NotEmpty(message = "Please select a role for this user.")
    private String role;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
