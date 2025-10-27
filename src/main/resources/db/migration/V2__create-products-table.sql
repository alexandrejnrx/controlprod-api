CREATE TABLE produtos
(
    id                    INT AUTO_INCREMENT PRIMARY KEY,
    unique_product_number INT          NOT NULL UNIQUE,
    serial_number         INT UNIQUE,
    production_date       DATE,
    batchNumber           INT          NOT NULL,
    producerName          VARCHAR(100) NOT NULL

);