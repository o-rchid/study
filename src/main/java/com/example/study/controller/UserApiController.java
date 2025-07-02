package com.example.study.controller;

import com.example.study.model.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("/me")
    public UserDto me(HttpSession httpSession) {
        var userObject = httpSession.getAttribute("USER");
        var userDto = (UserDto) userObject;

        if(userDto != null)
            return userDto;
        else
            return null;
    }
}
