package com.playstore.userms.serviceimpl;

import com.playstore.userms.dto.UserDto;
import com.playstore.userms.entity.User;
import com.playstore.userms.repository.UserRepository;
import com.playstore.userms.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) user.setRole("USER");
        return repo.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public List<UserDto> getAll() {
        return repo.findAll().stream()
                .map(u -> new UserDto(u.getId(), u.getUsername(), u.getFullName(), u.getRole()))
                .collect(Collectors.toList());
    }
}

