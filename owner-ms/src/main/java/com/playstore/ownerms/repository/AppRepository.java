package com.playstore.ownerms.repository;

import com.playstore.ownerms.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {
    List<App> findAllByOwnerId(Long ownerId);
}
