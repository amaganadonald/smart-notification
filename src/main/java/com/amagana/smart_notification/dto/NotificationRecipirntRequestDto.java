package com.amagana.smart_notification.dto;

public record NotificationRecipirntRequestDto(Long notificationId, String recipient, String email, String phone, String deviceId) {
    
}
