package com.playstore.notificationms.controller;


import com.playstore.notificationms.entity.Notification;
import com.playstore.notificationms.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/notifications")
public class NotificationController {


    private final NotificationService service;


    public NotificationController(NotificationService service) {
        this.service = service;
    }


    // Send and persist notification
    @PostMapping
    public ResponseEntity<Notification> send(@RequestParam String recipient, @RequestParam String message) {
        Notification saved = service.sendNotification(recipient, message);
        return ResponseEntity.ok(saved);
    }


}