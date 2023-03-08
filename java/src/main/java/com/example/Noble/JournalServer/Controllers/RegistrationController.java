package com.example.Noble.JournalServer.Controllers;

import com.example.Noble.JournalServer.User.Registration.UserDTO;
import com.example.Noble.JournalServer.User.User;
import com.example.Noble.JournalServer.User.UserAlreadyExistException;
import com.example.Noble.JournalServer.User.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService){

        this.userService = userService;

    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO dto = new UserDTO();
        model.addAttribute("user", dto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public void registerUserAccount(
            @RequestBody @Valid UserDTO userDto,
            HttpServletRequest request,
            Errors errors) {

        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            System.out.println("There is an account with that email address: "
                    + userDto.getEmailAddress());
        }

    }
}
