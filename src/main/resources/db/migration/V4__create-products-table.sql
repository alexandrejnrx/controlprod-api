CREATE TABLE products
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    product_type_id  INT          NOT NULL,
    nup              INT          NOT NULL UNIQUE,
    serial_number    INT UNIQUE,
    modem            VARCHAR(10),
    imei             VARCHAR(100),
    firmware_version VARCHAR(10),
    production_date  DATE,
    batch_number     INT          NOT NULL,
    producer_name    VARCHAR(100) NOT NULL,
    FOREIGN KEY (product_type_id) REFERENCES product_types (id)
);