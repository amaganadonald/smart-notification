package com.amagana.smart_notification.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.amagana.smart_notification.dto.NotificationRecipientResponseDto;
import com.amagana.smart_notification.dto.NotificationRecipirntRequestDto;
import com.amagana.smart_notification.entity.NotificationRecipient;


@Mapper(componentModel = "spring")
public interface NotificationRecipientMapper {

    @Mapping(target = "notification", ignore = true)
    @Mapping(target = "id", ignore = true)
    NotificationRecipient notificationRecipientRequestDtoToNotificationRecipient(NotificationRecipirntRequestDto notificationRecipirntRequestDto);

    NotificationRecipientResponseDto notificationRecipientToNotificationRecipientResponseDto(NotificationRecipient notificationRecipient);

}
