CREATE DATABASE MarioCartas;

USE MarioCartas;

-- Tabla de los personajes

CREATE TABLE IF NOT EXISTS personajes (

id_personaje INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20),
vida INT,
ataque INT,
coste INT,
id_clase INT
);

-- Tabla de las clases

CREATE TABLE IF NOT EXISTS clases (

id_clase INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20),
FOREIGN KEY (id_clase) REFERENCES personajes (id_clase) ON DELETE CASCADE
);

-- Tabla de las habilidades

CREATE TABLE IF NOT EXISTS habilidades (

id_habilidad INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20),
descripcion VARCHAR(50)
);

-- Tabla de los objetos

CREATE TABLE IF NOT EXISTS objetos (

id_objeto INT AUTO_INCREMENT PRIMARY KEY,
objeto VARCHAR(20),
coste INT,
ataque INT,
efecto VARCHAR(50)
);

