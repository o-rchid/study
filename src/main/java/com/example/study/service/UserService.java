package com.example.study.service;

import com.example.study.db.UserRepository;
import com.example.study.model.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()) {

            var userDto = optionalUser.get();

            if (userDto.getPassword().equals(pw))
                return userDto.getId();

        } else {
            throw new RuntimeException("User Not Found");
        }
        return null;
    }
}
