package com.playstore.appms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notification-ms")
public interface NotificationClient {

    @PostMapping("/notify/download")
    String sendDownloadNotification(@RequestParam Long ownerId, @RequestParam String appName);
}
