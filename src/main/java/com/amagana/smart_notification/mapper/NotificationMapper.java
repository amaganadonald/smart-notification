package com.amagana.smart_notification.mapper;

import org.mapstruct.Mapper;

import com.amagana.smart_notification.dto.NotificationRequestDto;
import com.amagana.smart_notification.dto.NotificationResponseDto;
import com.amagana.smart_notification.entity.Notification;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", ignore = true)
    Notification notificationRequestDtoToNotification(NotificationRequestDto notificationRequestDto);

    @Mapping(target = "recipients", ignore = true)
    NotificationResponseDto notificationToNotificationResponseDto(Notification notification);
    
}
