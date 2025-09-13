CREATE TABLE IF NOT EXISTS notification_recipient (
    id BIGINT PRIMARY KEY DEFAULT nextval('notification_recipient_id_seq'),
    notification_id BIGINT NOT NULL,
    recipient VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(15),
    device_id VARCHAR(50),
    FOREIGN KEY (notification_id) REFERENCES notification(id) ON DELETE CASCADE
);