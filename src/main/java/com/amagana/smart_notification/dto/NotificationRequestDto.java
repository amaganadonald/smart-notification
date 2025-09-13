package com.amagana.smart_notification.dto;

import java.time.LocalDateTime;

import com.amagana.smart_notification.enums.NotificationPriority;
import com.amagana.smart_notification.enums.NotificationStatus;

public record NotificationRequestDto(String sender, String subject, String message, Long type, NotificationPriority priority, NotificationStatus status, Boolean isRead, LocalDateTime sentAt, LocalDateTime readAt, Boolean isArchived, LocalDateTime archivedAt) {
    
}
