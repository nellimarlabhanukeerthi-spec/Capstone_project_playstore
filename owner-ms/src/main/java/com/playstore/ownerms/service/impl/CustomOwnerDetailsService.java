package com.playstore.ownerms.service.impl;

import com.playstore.ownerms.entity.Owner;
import com.playstore.ownerms.repository.OwnerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomOwnerDetailsService implements UserDetailsService {

    private final OwnerRepository ownerRepository;

    public CustomOwnerDetailsService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Owner owner = ownerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Owner not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(owner.getEmail())
                .password(owner.getPassword())
                .roles("OWNER")
                .build();
    }
}
