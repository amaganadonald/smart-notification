package com.amagana.smart_notification.service.impl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.amagana.smart_notification.dto.NotificationRequestDto;
import com.amagana.smart_notification.dto.NotificationResponseDto;
import com.amagana.smart_notification.entity.Notification;
import com.amagana.smart_notification.mapper.NotificationMapper;
import com.amagana.smart_notification.repository.NotificationRepository;
import com.amagana.smart_notification.service.NotificationService;
import com.amagana.smart_notification.utils.NotificationSpecification;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    NotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public List<NotificationResponseDto> getAllNotifications() {
        return notificationRepository.findAll().stream()
                                     .map(notificationMapper::notificationToNotificationResponseDto)
                                     .toList();
    }

    @Override
    public NotificationResponseDto getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .map(notificationMapper::notificationToNotificationResponseDto)
                .orElse(null);
    }

    @Override
    public NotificationResponseDto createNotification(NotificationRequestDto notificationRequestDto) {
        Notification savedNotification = notificationRepository.save(notificationMapper.notificationRequestDtoToNotification(notificationRequestDto));
        return notificationMapper.notificationToNotificationResponseDto(savedNotification);
    }

    @Override
    public NotificationResponseDto updateNotification(Long id, NotificationRequestDto notificationRequestDto) {
        Notification notification = notificationRepository.findById(id).orElse(null);
        if (notification == null) {
            return null;
        }
        notification.setArchivedAt(notificationRequestDto.archivedAt());
        notification.setIsRead(notificationRequestDto.isRead());
        notification.setMessage(notificationRequestDto.message());
        notification.setStatus(notificationRequestDto.status());
        Notification updatedNotification = notificationRepository.save(notification);
        return notificationMapper.notificationToNotificationResponseDto(updatedNotification);

    }

    @Override
    public List<NotificationResponseDto> getNotifications(NotificationRequestDto specs) {
        Specification<Notification> spec = NotificationSpecification.hasArchived(specs.isArchived())
            .and(NotificationSpecification.hasPriority(specs.priority()))
            .and(NotificationSpecification.hasRead(specs.isRead()));
        return notificationRepository.findAll(spec).stream()
                  .map(notificationMapper::notificationToNotificationResponseDto)
                  .toList();
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
    
}
