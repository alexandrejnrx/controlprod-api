CREATE TABLE projects
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(50),
    client_id INT     NOT NULL,
    active    BOOLEAN NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients (id)
);