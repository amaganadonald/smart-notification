package com.amagana.smart_notification.dto;

public record NotificationRecipirntRequestDto(Long notification, String recipient, String email, String phone, String deviceId) {
    
}
