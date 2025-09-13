package com.amagana.smart_notification.transform;


import com.amagana.smart_notification.enums.NotificationType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NotificationTypeConverter implements AttributeConverter<NotificationType, Integer> {
   
    @Override
    public Integer convertToDatabaseColumn(NotificationType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public NotificationType convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        for (NotificationType type : NotificationType.values()) {
            if (type.getCode() == dbData) return type;
        }
        throw new IllegalArgumentException("Unknown code: " + dbData);
    }
}
