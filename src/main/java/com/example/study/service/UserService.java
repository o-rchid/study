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
    public void login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()) {
            var userDto = optionalUser.get();

            if (userDto.getPassword().equals(pw)) {
                // cookie에 해당 정보를저장
                var cookie = new Cookie("authorization-cookie", userDto.getId());
                cookie.setDomain("localhost");
                cookie.setPath("/");
                cookie.setMaxAge(-1);

                httpServletResponse.addCookie(cookie);
            } else {
                throw new RuntimeException("Password Not Match");
            }
        } else {
            throw new RuntimeException("User Not Found");
        }
    }
}
