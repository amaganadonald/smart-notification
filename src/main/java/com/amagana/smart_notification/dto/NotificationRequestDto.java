package com.amagana.smart_notification.dto;

public record NotificationRequestDto(String sender, String subject, String message, Long type, String priority, String status, Boolean isRead, String sentAt, String readAt, Boolean isArchived, String archivedAt) {
    
}
