package com.amagana.smart_notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amagana.smart_notification.entity.NotificationPreference;

public interface NotificationPreferenceRepository extends JpaRepository<NotificationPreference, Long> {
    
} 
