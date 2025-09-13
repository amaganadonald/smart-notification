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

import com.amagana.smart_notification.dto.NotificationPreferenceRequestDto;
import com.amagana.smart_notification.dto.NotificationPreferenceResponseDto;
import com.amagana.smart_notification.service.NotificationPreferenceService;



@RestController
@RequestMapping("/api/v1/notificationPreference")
public class NotificationPreferenceController {


     private final NotificationPreferenceService notificationPreferenceService;

    NotificationPreferenceController(NotificationPreferenceService notificationPreferenceService) {
        this.notificationPreferenceService = notificationPreferenceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<NotificationPreferenceResponseDto>> getAllPreferenceNotifications(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(notificationPreferenceService.getPreferenceByUserId(id));
    }

    @PostMapping
    public ResponseEntity<NotificationPreferenceResponseDto> createPreferenceNotification(@RequestBody NotificationPreferenceRequestDto preference) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationPreferenceService.createPreference(preference));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationPreferenceResponseDto> updatePreferenceNotification(@PathVariable Long id, @RequestBody NotificationPreferenceRequestDto preference) {
        return ResponseEntity.status(HttpStatus.OK).body(notificationPreferenceService.updatePreference(id, preference));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePreferenceNotification(@PathVariable Long id) {
        notificationPreferenceService.deletePreference(id);
        return ResponseEntity.status(HttpStatus.OK).body("Preference Notification deleted");
    }
}
