package com.amagana.smart_notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amagana.smart_notification.entity.NotificationRecipient;

public interface NotificationRecipientRepository extends JpaRepository<NotificationRecipient, Long> {
    
}
