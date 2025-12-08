package com.playstore.appms.service;

import com.playstore.appms.dto.AppDto;
import com.playstore.appms.entity.App;

import java.util.List;

public interface AppService {

    App createApp(Long ownerId, AppDto dto);

    App updateApp(Long appId, AppDto dto);

    void deleteApp(Long appId);

    App getAppById(Long id);

    List<App> searchByName(String name);

    List<App> filterByRating(double rating);

    List<App> findByCategory(String category);

    void increaseDownloads(Long appId);

    List<App> ownerApps(Long ownerId);

    App changeVisibility(Long appId, boolean visible);
}
