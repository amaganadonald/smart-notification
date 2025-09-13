package com.amagana.smart_notification.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.amagana.smart_notification.entity.NotificationRecipient;
import com.amagana.smart_notification.enums.NotificationPriority;
import com.amagana.smart_notification.enums.NotificationStatus;
import com.amagana.smart_notification.enums.NotificationType;

public record NotificationResponseDto(Long id, String sender, String message, NotificationType type, NotificationPriority priority, NotificationStatus status, Boolean isRead, LocalDateTime sentAt, LocalDateTime readAt, Boolean isArchived, LocalDateTime archivedAt, List<NotificationRecipient> recipients) {
    
}
