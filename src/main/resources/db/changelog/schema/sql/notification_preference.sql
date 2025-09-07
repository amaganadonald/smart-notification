CREATE TABLE IF NOT EXISTS notification_preference (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    type_id BIGINT NOT NULL,
    is_enabled BOOLEAN DEFAULT TRUE,
    priority VARCHAR(20) DEFAULT 'NORMAL',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    UNIQUE (user_id, type_id),
    FOREIGN KEY (type_id) REFERENCES notification_type(id) ON DELETE CASCADE
);