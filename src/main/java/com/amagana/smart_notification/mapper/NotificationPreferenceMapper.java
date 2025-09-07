package com.amagana.smart_notification.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.amagana.smart_notification.dto.NotificationPreferenceRequestDto;
import com.amagana.smart_notification.dto.NotificationPreferenceResponseDto;
import com.amagana.smart_notification.entity.NotificationPreference;

@Mapper(componentModel = "spring")
public interface NotificationPreferenceMapper {

   
    @Mapping(target = "type", ignore = true)
    NotificationPreference notificationPreferenceRequestDtoToNotificationPreference(NotificationPreferenceRequestDto notificationPreferenceRequestDto);

    NotificationPreferenceResponseDto notificationPreferenceToNotificationPreferenceResponseDto(NotificationPreference notificationPreference);

}
