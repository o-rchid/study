package com.example.study.db;

import com.example.study.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRepository {

    private final List<UserDto> userList = new ArrayList<>();

    public Optional<UserDto> findByName(String name) {
        return userList
                .stream()
                .filter(it -> it.getName().equals(name))
                .findFirst();
    }

    public Optional<UserDto> findById(String id) {
        return userList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    @PostConstruct
    public void init() {
        userList.add(new UserDto(UUID.randomUUID().toString(), "해피", "1234"));
        userList.add(new UserDto(UUID.randomUUID().toString(),"금자", "1234"));
        userList.add(new UserDto(UUID.randomUUID().toString(),"달래", "1234"));
    }
}
