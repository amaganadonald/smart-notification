package com.amagana.smart_notification.enums;

public enum NotificationType {
    EMAIL(1),
    SMS(2),
    PUSH(3),
    IN_APP(4);

    private final int code;

    NotificationType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    
}
