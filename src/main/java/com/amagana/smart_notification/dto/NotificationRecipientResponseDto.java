package com.amagana.smart_notification.dto;

import com.amagana.smart_notification.entity.Notification;

public record NotificationRecipientResponseDto(Long id, Notification notificationId, String recipient, String email, String phone, String deviceId) {
    
}
