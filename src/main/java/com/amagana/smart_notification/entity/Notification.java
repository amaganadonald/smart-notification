package com.amagana.smart_notification.entity;

import java.time.LocalDateTime;

import com.amagana.smart_notification.enums.NotificationPriority;
import com.amagana.smart_notification.enums.NotificationStatus;
import com.amagana.smart_notification.enums.NotificationType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Notification {
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "notification_seq", sequenceName = "notification_seq", allocationSize= 1)
    private Long id;
    private String sender;
    private String subject;
    private String message;
    @OneToOne
    private NotificationType type;
    @OneToOne
    private NotificationPriority priority;
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
    private NotificationStatus status;
    private Boolean isRead;
    private Boolean isArchived;
    private LocalDateTime readAt;
    private LocalDateTime archivedAt;

    public Notification(Long id, String sender, String subject, String message, NotificationType type,
            NotificationPriority priority, LocalDateTime createdAt, LocalDateTime sentAt, NotificationStatus status,
            Boolean isRead, Boolean isArchived, LocalDateTime readAt, LocalDateTime archivedAt) {
        this.id = id;
        this.sender = sender;
        this.subject = subject;
        this.message = message;
        this.type = type;
        this.priority = priority;
        this.createdAt = createdAt;
        this.sentAt = sentAt;
        this.status = status;
        this.isRead = isRead;
        this.isArchived = isArchived;
        this.readAt = readAt;
        this.archivedAt = archivedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
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

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    public LocalDateTime getReadAt() {
        return readAt;
    }

    public void setReadAt(LocalDateTime readAt) {
        this.readAt = readAt;
    }

    public LocalDateTime getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(LocalDateTime archivedAt) {
        this.archivedAt = archivedAt;
    }

    
}
