package com.SpringFirstAttempt.sfa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.registrer(user);
    }

    @PostMapping("/loginn")
    public String login(Users user){
        System.out.println(user);
        return "Success";
    }


}
