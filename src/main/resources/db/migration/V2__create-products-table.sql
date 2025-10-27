CREATE TABLE products
(
    id                    INT AUTO_INCREMENT PRIMARY KEY,
    unique_product_number INT          NOT NULL UNIQUE,
    serial_number         INT UNIQUE,
    production_date       DATE,
    batch_number           INT          NOT NULL,
    producer_name          VARCHAR(100) NOT NULL

);