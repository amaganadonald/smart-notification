package com.amagana.smart_notification.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.amagana.smart_notification.enums.NotificationPriority;
import com.amagana.smart_notification.enums.NotificationStatus;
import com.amagana.smart_notification.enums.NotificationType;
import com.amagana.smart_notification.transform.NotificationTypeConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Notification {
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "notification_id_seq", sequenceName = "notification_id_seq", allocationSize= 1)
    private Long id;
    private String sender;
    private String subject;
    private String message;
    
    @Convert(converter = NotificationTypeConverter.class)
    private NotificationType type;

    @Enumerated(EnumType.STRING)
    private NotificationPriority priority;
    
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
    private Boolean isRead;
    private Boolean isArchived;
    private LocalDateTime readAt;
    private LocalDateTime archivedAt;
    @OneToMany(mappedBy = "notification")
    private List<NotificationRecipient> recipients;

    public Notification() {
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((sender == null) ? 0 : sender.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((priority == null) ? 0 : priority.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((sentAt == null) ? 0 : sentAt.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((isRead == null) ? 0 : isRead.hashCode());
        result = prime * result + ((isArchived == null) ? 0 : isArchived.hashCode());
        result = prime * result + ((readAt == null) ? 0 : readAt.hashCode());
        result = prime * result + ((archivedAt == null) ? 0 : archivedAt.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notification other = (Notification) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (sender == null) {
            if (other.sender != null)
                return false;
        } else if (!sender.equals(other.sender))
            return false;
        if (subject == null) {
            if (other.subject != null)
                return false;
        } else if (!subject.equals(other.subject))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (type != other.type)
            return false;
        if (priority != other.priority)
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (sentAt == null) {
            if (other.sentAt != null)
                return false;
        } else if (!sentAt.equals(other.sentAt))
            return false;
        if (status != other.status)
            return false;
        if (isRead == null) {
            if (other.isRead != null)
                return false;
        } else if (!isRead.equals(other.isRead))
            return false;
        if (isArchived == null) {
            if (other.isArchived != null)
                return false;
        } else if (!isArchived.equals(other.isArchived))
            return false;
        if (readAt == null) {
            if (other.readAt != null)
                return false;
        } else if (!readAt.equals(other.readAt))
            return false;
        if (archivedAt == null) {
            if (other.archivedAt != null)
                return false;
        } else if (!archivedAt.equals(other.archivedAt))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Notification [id=" + id + ", sender=" + sender + ", subject=" + subject + ", message=" + message
                + ", type=" + type + ", priority=" + priority + ", createdAt=" + createdAt + ", sentAt=" + sentAt
                + ", status=" + status + ", isRead=" + isRead + ", isArchived=" + isArchived + ", readAt=" + readAt
                + ", archivedAt=" + archivedAt + ", getId()=" + getId() + ", getSender()=" + getSender()
                + ", getSubject()=" + getSubject() + ", getMessage()=" + getMessage() + ", getType()=" + getType()
                + ", getPriority()=" + getPriority() + ", getCreatedAt()=" + getCreatedAt() + ", getSentAt()="
                + getSentAt() + ", getStatus()=" + getStatus() + ", getIsRead()=" + getIsRead() + ", getIsArchived()="
                + getIsArchived() + ", getReadAt()=" + getReadAt() + ", getArchivedAt()=" + getArchivedAt()
                + ", hashCode()=" + hashCode() + "]";
    }

    
}
