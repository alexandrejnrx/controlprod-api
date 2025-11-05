CREATE TABLE clients
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(50),
    client_type VARCHAR(10) NOT NULL,
    active      BOOLEAN     NOT NULL
);