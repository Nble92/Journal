package com.example.Noble.JournalServer.Controllers;

import com.example.Noble.JournalServer.Security.JwtUtil;
import com.example.Noble.JournalServer.User.Registration.AuthenticationResponse;
import com.example.Noble.JournalServer.User.Registration.UserDTO;
import com.example.Noble.JournalServer.User.Registration.UserDetailsServiceImpl;
import com.example.Noble.JournalServer.User.Registration.UserNotFoundException;
import com.example.Noble.JournalServer.User.User;
import com.example.Noble.JournalServer.User.UserAlreadyExistException;
import com.example.Noble.JournalServer.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private final UserDetailsServiceImpl userDetailsService;

    public RegistrationController(UserService userService, UserDetailsServiceImpl userDetailsService){

        this.userService = userService;
        this.userDetailsService = userDetailsService;

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

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody UserDTO dto) throws Exception, UserNotFoundException {
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
                );
            } catch (BadCredentialsException e) {
                throw new Exception("Incorrect username or password", e);
            }

            final UserDetails details = userDetailsService.loadUserByUsername(dto.getUsername());
            final String jwt = jwtUtil.generateToken(details);

            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }
    }



