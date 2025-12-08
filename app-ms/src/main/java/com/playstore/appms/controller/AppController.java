package com.playstore.appms.controller;

import com.playstore.appms.dto.AppDto;
import com.playstore.appms.entity.App;
import com.playstore.appms.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apps")
@RequiredArgsConstructor
public class AppController {

    private final AppService service;

    @PostMapping("/create/{ownerId}")
    public App create(@PathVariable Long ownerId, @RequestBody AppDto dto) {
        return service.createApp(ownerId, dto);
    }

    @PutMapping("/{appId}")
    public App update(@PathVariable Long appId, @RequestBody AppDto dto) {
        return service.updateApp(appId, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteApp(id);
        return "Deleted";
    }

    @GetMapping("/{id}")
    public App get(@PathVariable Long id) {
        return service.getAppById(id);
    }

    @GetMapping("/search")
    public List<App> search(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/filter")
    public List<App> filter(@RequestParam double rating) {
        return service.filterByRating(rating);
    }

    @GetMapping("/category/{cat}")
    public List<App> category(@PathVariable String cat) {
        return service.findByCategory(cat);
    }

    @PutMapping("/download/{id}")
    public String download(@PathVariable Long id) {
        service.increaseDownloads(id);
        return "Download success";
    }

    @GetMapping("/owner/{ownerId}")
    public List<App> ownerApps(@PathVariable Long ownerId) {
        return service.ownerApps(ownerId);
    }

    @PutMapping("/visibility/{appId}")
    public App visibility(@PathVariable Long appId, @RequestParam boolean visible) {
        return service.changeVisibility(appId, visible);
    }
}
