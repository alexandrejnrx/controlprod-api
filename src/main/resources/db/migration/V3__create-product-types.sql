CREATE TABLE product_types
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(100),
    internal_code VARCHAR(10),
    project_id    INT     NOT NULL,
    active        BOOLEAN NOT NULL,
    FOREIGN KEY (project_id) REFERENCES projects (id)
);