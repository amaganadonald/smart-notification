package com.amagana.smart_notification.controller;

import com.amagana.smart_notification.dto.NotificationRequestDto;
import com.amagana.smart_notification.dto.NotificationResponseDto;
import com.amagana.smart_notification.mapper.NotificationMapper;
import com.amagana.smart_notification.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NotificationController.class)
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotificationService notificationService;

    private NotificationMapper notificationMapper = Mappers.getMapper(NotificationMapper.class);

    @Test
    void getAllNotifications_shouldReturnList() throws Exception {
        NotificationResponseDto dto = new NotificationResponseDto();
        List<NotificationResponseDto> dtos = Arrays.asList(dto);
        Mockito.when(notificationService.getAllNotifications()).thenReturn(dtos);

        mockMvc.perform(get("/api/v1/notification"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void createNotification_shouldReturnCreated() throws Exception {
        NotificationResponseDto responseDto = new NotificationResponseDto();
        Mockito.when(notificationService.createNotification(any(NotificationRequestDto.class))).thenReturn(responseDto);

        mockMvc.perform(post("/api/v1/notification")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isCreated());
    }

    @Test
    void updateNotification_shouldReturnOk() throws Exception {
        NotificationResponseDto responseDto = new NotificationResponseDto();
        Mockito.when(notificationService.updateNotification(eq(1L), any(NotificationRequestDto.class))).thenReturn(responseDto);

        mockMvc.perform(put("/api/v1/notification/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllNotificationsBySearch_shouldReturnList() throws Exception {
        NotificationResponseDto dto = new NotificationResponseDto();
        List<NotificationResponseDto> dtos = Arrays.asList(dto);
        Mockito.when(notificationService.getNotifications(any(NotificationRequestDto.class))).thenReturn(dtos);

        mockMvc.perform(get("/api/v1/notification/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void deleteNotification_shouldReturnOk() throws Exception {
        Mockito.doNothing().when(notificationService).deleteNotification(1L);

        mockMvc.perform(delete("/api/v1/notification/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Notification deleted"));
    }
}
