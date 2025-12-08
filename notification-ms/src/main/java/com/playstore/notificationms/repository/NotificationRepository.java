package com.playstore.notificationms.repository;



import com.playstore.notificationms.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
