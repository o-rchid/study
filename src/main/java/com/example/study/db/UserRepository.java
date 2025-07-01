package com.example.study.db;

import com.example.study.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepository {

    private List<UserDto> userList = new ArrayList<>();

    public Optional<UserDto> findByName(String name) {
        return userList
                .stream()
                .filter(it -> it.getName().equals(name))
                .findFirst();
    }

    @PostConstruct
    public void init() {
        userList.add(new UserDto("해피", "1234"));
        userList.add(new UserDto("금자", "1234"));
        userList.add(new UserDto("달래", "1234"));
    }
}
