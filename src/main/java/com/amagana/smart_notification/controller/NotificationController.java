package com.amagana.smart_notification.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amagana.smart_notification.dto.NotificationRequestDto;
import com.amagana.smart_notification.dto.NotificationResponseDto;
import com.amagana.smart_notification.service.NotificationService;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {
    

    private final NotificationService notificationService;

    NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<List<NotificationResponseDto>> getAllNotifications() {
        return ResponseEntity.status(HttpStatus.OK).body(notificationService.getAllNotifications());
    }

    @PostMapping
    public ResponseEntity<NotificationResponseDto> createNotification(@RequestBody NotificationRequestDto notificationRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationService.createNotification(notificationRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationResponseDto> updateNotification(@PathVariable Long id, @RequestBody NotificationRequestDto notificationRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(notificationService.updateNotification(id, notificationRequestDto));
    }

    @GetMapping("search")
    public ResponseEntity<List<NotificationResponseDto>> getAllNotifications(@RequestBody NotificationRequestDto notificationRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(notificationService.getNotifications(notificationRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.status(HttpStatus.OK).body("Notification deleted");
    }
}
