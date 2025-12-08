package com.playstore.notificationms.service;



import com.playstore.notificationms.entity.Notification;

public interface NotificationService {
    Notification sendNotification(String recipient, String message);
}
