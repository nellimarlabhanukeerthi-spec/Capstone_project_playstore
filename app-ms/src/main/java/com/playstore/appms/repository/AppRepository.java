package com.playstore.appms.repository;

import com.playstore.appms.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {

    List<App> findByNameContainingIgnoreCase(String name);

    List<App> findByCategoryIgnoreCase(String category);

    List<App> findByRatingGreaterThanEqual(double rating);

    List<App> findByOwnerId(Long ownerId);
}
