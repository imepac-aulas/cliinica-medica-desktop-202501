DROP DATABASE IF EXISTS clinica;
CREATE DATABASE clinica
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

USE clinica;

CREATE TABLE especialidade (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE pessoas (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  telefone VARCHAR(20),
  email VARCHAR(100)
);

CREATE TABLE medico (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  crm VARCHAR(20) NOT NULL,
  id_pessoa BIGINT NOT NULL,
  id_especialidade BIGINT NOT NULL,
  FOREIGN KEY (id_pessoa) REFERENCES pessoas(id),
  FOREIGN KEY (id_especialidade) REFERENCES especialidade(id)
);

CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL,
    perfil VARCHAR(50) NOT NULL
);

CREATE TABLE consultas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_medico BIGINT NOT NULL,
    id_paciente BIGINT NOT NULL,
    data_hora DATETIME NOT NULL,
    motivo VARCHAR(255),
    FOREIGN KEY (id_medico) REFERENCES medico(id),
    FOREIGN KEY (id_paciente) REFERENCES pessoas(id)
);
