CREATE TABLE technical_assistance
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    date          DATE          NOT NULL,
    requester     VARCHAR(50)   NOT NULL,
    origin        VARCHAR(10)   NOT NULL,
    product_id    INT           NOT NULL,
    defect_reason VARCHAR(150)  NOT NULL,
    responsible   VARCHAR(50)   NOT NULL,
    resolution    VARCHAR(1000) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products (id)
);