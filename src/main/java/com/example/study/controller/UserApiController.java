package com.example.study.controller;

import com.example.study.db.UserRepository;
import com.example.study.model.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(
            @RequestHeader(name = "authorization", required = false)
            String authorizationHeader
    ) {

        log.info("authorizationHeader : {}", authorizationHeader);
        var optionalUserDto = userRepository.findById(authorizationHeader);
        return optionalUserDto.get();

    }
}
