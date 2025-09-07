CREATE TABLE IF NOT EXISTS recipients (
    id BIGSERIAL PRIMARY KEY,
    notification_id BIGINT NOT NULL,
    recipient VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(15),
    device_id VARCHAR(100),
    PRIMARY KEY (notification_id, recipient),
    FOREIGN KEY (notification_id) REFERENCES notification(id) ON DELETE CASCADE
);