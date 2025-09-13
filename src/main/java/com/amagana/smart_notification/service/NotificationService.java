package com.amagana.smart_notification.service;

import java.util.List;


import com.amagana.smart_notification.dto.NotificationRequestDto;
import com.amagana.smart_notification.dto.NotificationResponseDto;

public interface NotificationService {

    List<NotificationResponseDto> getAllNotifications();
    NotificationResponseDto getNotificationById(Long id);
    NotificationResponseDto createNotification(NotificationRequestDto notificationRequestDto);
    NotificationResponseDto updateNotification(Long id, NotificationRequestDto notificationRequestDto);
    List<NotificationResponseDto> getNotifications(NotificationRequestDto spec);
    void deleteNotification(Long id);
    
}
