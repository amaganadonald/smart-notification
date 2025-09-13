package com.amagana.smart_notification.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amagana.smart_notification.dto.NotificationPreferenceRequestDto;
import com.amagana.smart_notification.dto.NotificationPreferenceResponseDto;
import com.amagana.smart_notification.entity.NotificationPreference;
import com.amagana.smart_notification.mapper.NotificationPreferenceMapper;
import com.amagana.smart_notification.repository.NotificationPreferenceRepository;
import com.amagana.smart_notification.service.NotificationPreferenceService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificationPreferenceServiceImpl implements NotificationPreferenceService {

    private final NotificationPreferenceRepository notificationPreferenceRepository;
    private final NotificationPreferenceMapper notificationPreferenceMapper;

    NotificationPreferenceServiceImpl(NotificationPreferenceRepository notificationPreferenceRepository, NotificationPreferenceMapper notificationPreferenceMapper) {
        this.notificationPreferenceRepository = notificationPreferenceRepository;
        this.notificationPreferenceMapper = notificationPreferenceMapper;
    }

    @Override
    public List<NotificationPreferenceResponseDto> getPreferenceByUserId(Long id) {
        return notificationPreferenceRepository.findAll()
                        .stream()
                        .map(notificationPreferenceMapper::notificationPreferenceToNotificationPreferenceResponseDto)
                        .toList();
    }

    @Override
    public NotificationPreferenceResponseDto createPreference(NotificationPreferenceRequestDto preference) {
        NotificationPreference notificationPreference = notificationPreferenceRepository.save(notificationPreferenceMapper.notificationPreferenceRequestDtoToNotificationPreference(preference));
        return notificationPreferenceMapper.notificationPreferenceToNotificationPreferenceResponseDto(notificationPreference);
    }

    @Override
    public NotificationPreferenceResponseDto updatePreference(Long id, NotificationPreferenceRequestDto preference) {
        NotificationPreference notificationPreference = notificationPreferenceRepository.findById(id).orElse(null);
        if (notificationPreference == null) {
            return null;
        }
        notificationPreference.setEnabled(preference.isEnabled());
        notificationPreference.setPriority(preference.priority());
        notificationPreference.setType(preference.type());
        notificationPreference.setUserId(preference.userId());

        return notificationPreferenceMapper.notificationPreferenceToNotificationPreferenceResponseDto(notificationPreferenceRepository.save(notificationPreference));
    }

    @Override
    public void deletePreference(Long id) {
        notificationPreferenceRepository.deleteById(id);
    }
    
}
