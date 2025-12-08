package com.playstore.userms.service;

import com.playstore.userms.dto.UserDto;
import com.playstore.userms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> findByUsername(String username);
    List<UserDto> getAll();
}
