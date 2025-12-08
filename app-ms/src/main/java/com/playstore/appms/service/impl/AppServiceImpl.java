package com.playstore.appms.service.impl;

import com.playstore.appms.dto.AppDto;
import com.playstore.appms.exception.AppNotFoundException;
import com.playstore.appms.feign.NotificationClient;
import com.playstore.appms.entity.App;
import com.playstore.appms.repository.AppRepository;
import com.playstore.appms.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final AppRepository repo;
    private final NotificationClient notificationClient;

    @Override
    public App createApp(Long ownerId, AppDto dto) {
        App app = App.builder()
                .ownerId(ownerId)
                .name(dto.getName())
                .description(dto.getDescription())
                .version(dto.getVersion())
                .category(dto.getCategory())
                .releaseDate(LocalDate.now())
                .rating(0.0)
                .downloads(0)
                .visible(true)
                .build();

        return repo.save(app);
    }

    @Override
    public App updateApp(Long id, AppDto dto) {
        App app = repo.findById(id)
                .orElseThrow(() -> new AppNotFoundException("App not found"));

        app.setName(dto.getName());
        app.setDescription(dto.getDescription());
        app.setVersion(dto.getVersion());
        app.setCategory(dto.getCategory());

        return repo.save(app);
    }

    @Override
    public void deleteApp(Long id) {
        repo.deleteById(id);
    }

    @Override
    public App getAppById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new AppNotFoundException("App not found"));
    }

    @Override
    public List<App> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<App> filterByRating(double rating) {
        return repo.findByRatingGreaterThanEqual(rating);
    }

    @Override
    public List<App> findByCategory(String category) {
        return repo.findByCategoryIgnoreCase(category);
    }

    @Override
    public void increaseDownloads(Long appId) {
        App app = getAppById(appId);
        app.setDownloads(app.getDownloads() + 1);
        repo.save(app);

        notificationClient.sendDownloadNotification(app.getOwnerId(), app.getName());
    }

    @Override
    public List<App> ownerApps(Long ownerId) {
        return repo.findByOwnerId(ownerId);
    }

    @Override
    public App changeVisibility(Long appId, boolean visible) {
        App app = getAppById(appId);
        app.setVisible(visible);
        return repo.save(app);
    }
}
