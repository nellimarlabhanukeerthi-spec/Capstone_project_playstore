package com.playstore.notificationms.service.impl;


import com.playstore.notificationms.entity.Notification;
import com.playstore.notificationms.repository.NotificationRepository;
import com.playstore.notificationms.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    public NotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notification sendNotification(String recipient, String message) {
        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setMessage(message);
        return repository.save(notification);  // stores in H2
    }
}
