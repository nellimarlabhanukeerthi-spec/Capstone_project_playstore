package com.playstore.ownerms.service.impl;

import com.playstore.ownerms.dto.RegisterOwnerRequest;
import com.playstore.ownerms.entity.Owner;
import com.playstore.ownerms.repository.OwnerRepository;
import com.playstore.ownerms.service.OwnerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

    public OwnerServiceImpl(OwnerRepository ownerRepository, PasswordEncoder passwordEncoder) {
        this.ownerRepository = ownerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Owner register(RegisterOwnerRequest req) {
        Owner owner = new Owner();
        owner.setName(req.getName());
        owner.setEmail(req.getEmail());
        owner.setPassword(passwordEncoder.encode(req.getPassword()));
        return ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> findByEmail(String email) {
        return ownerRepository.findByEmail(email);
    }
}
