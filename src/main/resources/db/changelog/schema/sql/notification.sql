CREATE TABLE IF NOT EXISTS notification (
    id BIGINT PRIMARY KEY DEFAULT nextval('notification_id_seq'),
    sender VARCHAR(100) NOT NULL,
    subject VARCHAR(100),
    message TEXT NOT NULL,
    type INT NOT NULL,
    priority VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sent_at TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    is_read BOOLEAN DEFAULT FALSE,
    read_at TIMESTAMP,
    is_archived BOOLEAN DEFAULT FALSE,
    archived_at TIMESTAMP,
    FOREIGN KEY (type) REFERENCES notification_type(id) ON DELETE SET NULL
);