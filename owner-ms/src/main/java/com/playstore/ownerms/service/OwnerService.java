package com.playstore.ownerms.service;

import com.playstore.ownerms.dto.RegisterOwnerRequest;
import com.playstore.ownerms.entity.Owner;

import java.util.Optional;

public interface OwnerService {
    Owner register(RegisterOwnerRequest req);
    Optional<Owner> findByEmail(String email);
}
