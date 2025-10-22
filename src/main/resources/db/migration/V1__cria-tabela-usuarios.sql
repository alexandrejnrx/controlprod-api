CREATE TABLE usuarios
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    nome         VARCHAR(100),
    nome_usuario VARCHAR(20)  NOT NULL UNIQUE,
    email        VARCHAR(100) NOT NULL UNIQUE,
    senha        VARCHAR(255) NOT NULL,
    perfil       VARCHAR(10)  NOT NULL
);