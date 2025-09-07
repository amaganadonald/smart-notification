package com.amagana.smart_notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class NotificationRecipient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "recipient_seq", sequenceName = "recipient_seq", allocationSize = 1)
    private Long id;
    @OneToOne
    private Notification notificationId;
    private String recipient;
    private String email;
    private String phone;
    private String deviceId;

    public NotificationRecipient() {
    }

    public NotificationRecipient(Long id, Notification notificationId, String recipient, String email, String phone,
            String deviceId) {
        this.id = id;
        this.notificationId = notificationId;
        this.recipient = recipient;
        this.email = email;
        this.phone = phone;
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and Setters
    public Notification getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Notification notificationId) {
        this.notificationId = notificationId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
