package com.amagana.smart_notification.dto;

import com.amagana.smart_notification.enums.NotificationPriority;
import com.amagana.smart_notification.enums.NotificationType;

public record NotificationResponseDto(Long id, String sender, String message, NotificationType type, NotificationPriority priority, String status, Boolean isRead, String sentAt, String readAt, Boolean isArchived, String archivedAt) {
    
}
