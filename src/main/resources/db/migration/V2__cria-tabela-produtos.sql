CREATE TABLE produtos
(
    id                    INT AUTO_INCREMENT PRIMARY KEY,
    numero_unico_producao INT          NOT NULL UNIQUE,
    numero_serie                INT UNIQUE,
    data_producao         DATE,
    lote                  INT          NOT NULL,
    responsavel           VARCHAR(100) NOT NULL

);