package com.playstore.ownerms.controller;

import com.playstore.ownerms.entity.*;
import com.playstore.ownerms.repository.*;
import com.playstore.ownerms.security.JwtUtil;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/owner")
public class OwnerAppController {

    private final AppRepository appRepository;
    private final OwnerRepository ownerRepository;
    private final JwtUtil jwtUtil;

    public OwnerAppController(AppRepository appRepository, OwnerRepository ownerRepository, JwtUtil jwtUtil) {
        this.appRepository = appRepository;
        this.ownerRepository = ownerRepository;
        this.jwtUtil = jwtUtil;
    }

    // create app (owner authenticated)
    @PostMapping("/apps")
    public ResponseEntity<?> createApp(@RequestBody App app, Authentication authentication) {
        String email = authentication.getName();
        Optional<Owner> maybe = ownerRepository.findByEmail(email);
        if (maybe.isEmpty()) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Owner not found");
        Owner owner = maybe.get();
        app.setOwner(owner);
        App saved = appRepository.save(app);
        return ResponseEntity.ok(saved);
    }

    // list owner's apps
    @GetMapping("/apps")
    public ResponseEntity<?> listApps(Authentication authentication) {
        String email = authentication.getName();
        Optional<Owner> maybe = ownerRepository.findByEmail(email);
        if (maybe.isEmpty()) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Owner not found");
        Owner owner = maybe.get();
        List<App> apps = appRepository.findAllByOwnerId(owner.getId());
        return ResponseEntity.ok(apps);
    }

    // update visibility
    @PatchMapping("/apps/{appId}/visibility")
    public ResponseEntity<?> toggleVisibility(@PathVariable Long appId, Authentication authentication) {
        String email = authentication.getName();
        Optional<Owner> maybe = ownerRepository.findByEmail(email);
        if (maybe.isEmpty()) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Owner not found");
        Owner owner = maybe.get();
        Optional<App> maybeApp = appRepository.findById(appId);
        if (maybeApp.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("App not found");
        App app = maybeApp.get();
        if (!app.getOwner().getId().equals(owner.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not owner of this app");
        }

        app.setVisible(!app.isVisible());
        appRepository.save(app);
        return ResponseEntity.ok(app);
    }
}
