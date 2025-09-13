package com.amagana.smart_notification.entity;

import java.time.LocalDateTime;

import com.amagana.smart_notification.enums.NotificationPriority;
import com.amagana.smart_notification.enums.NotificationType;
import com.amagana.smart_notification.transform.NotificationTypeConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class NotificationPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "notification_preference_id_seq", sequenceName = "notification_preference_id_seq", allocationSize = 1)
    private Long id;
    private String userId;
    
    @Convert(converter = NotificationTypeConverter.class)
    private NotificationType type;

    private boolean isEnabled;
    
    @Enumerated(EnumType.STRING)
    private NotificationPriority priority;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public NotificationPreference() {
    }

    public NotificationPreference(Long id, String userId, NotificationType type, boolean isEnabled,
            NotificationPriority priority, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.isEnabled = isEnabled;
        this.priority = priority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public NotificationPriority getPriority() {
        return priority;
    }

    public void setPriority(NotificationPriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    
}
