package com.amagana.smart_notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amagana.smart_notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}