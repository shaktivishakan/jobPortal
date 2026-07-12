package com.example.dto;

import com.example.models.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private Long id;
    private String notificationMessage;
    private Boolean isRead;
    private LocalDateTime createdAt;

    public static NotificationResponse from(Notification notification)
    {
        NotificationResponse response = new NotificationResponse();
        response.setId(notification.getId());
        response.setNotificationMessage(notification.getMessage());
        response.setIsRead(notification.getIsRead());
        response.setCreatedAt(notification.getCreatedAt());

        return response;
    }

}
