package com.amagana.smart_notification.dto;

import java.time.LocalDateTime;

import com.amagana.smart_notification.enums.NotificationPriority;
import com.amagana.smart_notification.enums.NotificationType;

public record NotificationPreferenceResponseDto(String userId, NotificationType type, NotificationPriority priority, Boolean isEnabled, LocalDateTime createdAt, LocalDateTime updatedAt) {
    
}
