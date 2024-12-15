package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.CustomUser;
import com.demo.service.CustomUserService;

@RestController
public class UserController {
    
    @Autowired
    CustomUserService userService;

    @PostMapping("/register")
    public String registor(@RequestBody CustomUser user)
    {
        String password = user.getPassword();
        userService.register(user);
        user.setPassword(password);
        return userService.verify(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody CustomUser user)
    {
        //return "hello";
        return userService.verify(user);
    }
}
