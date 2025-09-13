CREATE TABLE IF NOT EXISTS notification_type (
    id BIGINT PRIMARY KEY DEFAULT nextval('notification_type_id_seq'),
    name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE
);