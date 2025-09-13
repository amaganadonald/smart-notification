package com.amagana.smart_notification.service;

import java.util.List;

import com.amagana.smart_notification.dto.NotificationPreferenceRequestDto;
import com.amagana.smart_notification.dto.NotificationPreferenceResponseDto;

public interface NotificationPreferenceService {

    List<NotificationPreferenceResponseDto> getPreferenceByUserId(Long id);
    NotificationPreferenceResponseDto createPreference(NotificationPreferenceRequestDto preference);
    NotificationPreferenceResponseDto updatePreference(Long id, NotificationPreferenceRequestDto preference);
    void deletePreference(Long id);
    
}
