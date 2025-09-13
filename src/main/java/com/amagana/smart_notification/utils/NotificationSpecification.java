package com.amagana.smart_notification.utils;

import org.springframework.data.jpa.domain.Specification;

import com.amagana.smart_notification.entity.Notification;
import com.amagana.smart_notification.enums.NotificationPriority;

public class NotificationSpecification {

    private NotificationSpecification() {
    }
    
    public static Specification<Notification> hasArchived(Boolean archived) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isArchived"), archived);
    }

    public static Specification<Notification> hasRead(Boolean read) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isRead"), read);
    }

    public static Specification<Notification> hasPriority(NotificationPriority priority) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("priority"), priority);
    }
}
