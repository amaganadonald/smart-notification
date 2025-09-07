package com.amagana.smart_notification.dto;

import java.time.LocalDateTime;

public record NotificationPreferenceRequestDto(String userId, Long type, String priority, Boolean isEnabled, LocalDateTime createdAt, LocalDateTime updatedAt) {
    
}
