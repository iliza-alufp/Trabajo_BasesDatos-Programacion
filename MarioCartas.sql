CREATE DATABASE MarioCartas;

USE MarioCartas;

-- Tabla de los personajes

CREATE TABLE IF NOT EXISTS personajes (

id_personaje INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20),
vida INT,
ataque INT,
coste INT,
id_clase INT,
FOREIGN KEY (id_clase) REFERENCES clases (id_clase) ON DELETE CASCADE
);

-- Tabla de las clases

CREATE TABLE IF NOT EXISTS clases (

id_clase INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20)

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

-- Elementos de la tabla clases
INSERT INTO clases (id_clase, nombre) VALUES
(1, 'Humano'),
(2, 'Koopa'),
(3, 'Goomba'),
(4, 'Toad'),
(5, 'Planta'),
(6, 'Fantasma'),
(7, 'Dinosaurio'),
(8, 'Rana'),
(9, 'Ratón'),
(10, 'Cangrejo'),
(11, 'Topo'),
(12, 'Estrella'),
(13, 'Hey-Ho'),
(14, 'Bomba'),
(15, 'Kong'),
(16, 'Judía'),
(17, 'Conejo'),
(18, 'Pez'),
(19, 'Ave'),
(20, 'Murciélago'),
(21, 'Kremling');

-- Elementos de la tabla personajes humanos
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(1, 'Mario', 7, 6, 5, 1),
(2, 'Luigi', 6, 7, 5, 1),
(3, 'Peach', 7, 4, 5, 1),
(4, 'Daisy', 7, 4, 5, 1),
(5, 'Estela', 5, 7, 5, 1),
(6, 'Pauline', 6, 5, 5, 1),
(7, 'Wario', 9, 7, 8, 1),
(8, 'Waluigi', 3, 2, 5, 1);

-- Elementos de la tabla personajes Kong
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(8, 'Donkey Kong', 6, 7, 7, 15),
(9, 'Diddy Kong', 3, 4, 3, 15),
(10, 'Dixie Kong', 4, 3, 3, 15),
(11, 'Cranky Kong', 3, 2, 3, 15);

-- Elementos de la tabla personajes Toad
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(10, 'Toad', 2, 1, 1, 4),
(11, 'Toadette', 4, 3, 3, 4),
(12, 'Maestro Kinopio', 3, 3, 3, 4),
(13, 'Capitán Toad', 4, 4, 3, 4),

-- Elementos de la tabla personajes Koopa
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(14, 'Koopa Troopa', 2, 1, 1, 2),
(15, 'Koopa Paratroopa', 3, 1, 1, 2),
(16, 'Huesitos', 1, 1, 3, 2),
(17, 'Hammer Bro', 3, 4, 3, 2),
(18, 'Lakitu', 3, 2, 4, 2),
(19, 'Pinchón', 1, 3, 2, 2),
(20, 'Buzzy Beetle', 4, 1, 2, 2),
(21, 'Bowser', 8, 8, 7, 2),
(22, 'Bowsy', 6, 4, 4, 2),
(23, 'Larry', 4, 4, 4, 2),
(24, 'Morton', 4, 5, 4, 2),
(25, 'Wendy', 4, 3, 4, 2),
(26, 'Iggy', 4, 4, 4, 2),
(27, 'Roy', 4, 6, 4, 2),
(28, 'Lemmy', 4, 1, 4, 2),
(29, 'Ludwig', 4, 7, 4, 2),
(30, 'Boom Boom', 3, 4, 3),
(31, 'Pom Pom', 4, 3, 3),
(32, 'Bowsitos', 8, 8, 7, 2),
(33, 'Spike', 2, 5, 3, 2),
(34, 'Kamek', 4, 2, 3, 2),
(35, 'Mechakoopa', 2, 2, 2, 2),
(36, 'Kooper', 3, 4, 3, 2),
(37, 'Parakarry', 4, 5, 3, 2),
(38, 'Koops', 5, 3, 3, 2),
(39, 'Lakilester', 4, 3, 3, 2),
(40, 'Kammy', 4, 2, 3, 2),
(41, 'Placapum', 6, 2, 4, 2);

-- Elementos de la tabla personajes Goomba
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(41, 'Goomba', 1, 1, 0, 3),
(42, 'Rey Goomba', 5, 3, 4, 3),
(43, 'Goombario', 3, 4, 3, 3),
(44, 'Goomarina', 3, 5, 3, 3);

-- Elementos de la tabla personajes Planta
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(45, 'Planta Piraña', 1, 4, 3, 5),
(46, 'Floro Piraña', 5, 5, 4, 5),
(47, 'Floruga', 3, 3, 3, 5),
(48, 'Forestano', 4, 2, 3, 5),
(49, 'Pokey', 6, 2, 4, 5);

-- Elementos de la tabla personajes Fantasma
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(47, 'Boo', 4, 1, 2, 6),
(48, 'Rey Boo', 7, 8, 6, 6),
(49, 'Lady Bow', 3, 4, 3, 6)
(50, 'Claudia', 5, 3, 3, 6),
(51, 'Bibiana', 4, 5, 3, 6),
(52, 'Boo Bomba', 2, 1, 3, 6),
(53, 'Reina de las Sombras', 9, 6, 7, 6),
(54, 'Fantasmirón', 4, 1, 2, 6);

-- Elementos de la tabla personajes Dinosaurio
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(54, 'Yoshi', 5, 5, 4, 7),
(55, 'Birdo', 4, 5, 4, 7),
(56, 'Reznor', 4, 4, 4, 7);

-- Elementos de la tabla personajes Rana
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(57, 'Wart', 7, 7, 6, 8),
(58, 'Monerrana', 3, 2, 3, 8);

-- Elementos de la tabla personajes Ratón
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(59, 'Mouser', 4, 5, 4, 9),
(60, 'Lupina', 4, 4, 3, 9);

-- Elementos de la tabla personajes Cangrejo
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(60, 'Clawglip', 4, 5, 4, 10),
(61, 'Sidestepper', 2, 2, 2, 10);

-- Elementos de la tabla personajes Topo
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(62, 'Monty', 1, 2, 1, 11),
(63, 'Tortopo', 2, 3, 2, 11);

-- Elementos de la tabla personajes Estrella
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(64, 'Destello', 1, 3, 2, 12),
(65, 'Nebu', 2, 3, 2, 12),
(66, 'Lubba', 3, 3, 3, 12);

-- Elementos de la tabla personajes Hey-Ho
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(67, 'Shy Guy', 2, 1, 1, 13);

-- Elementos de la tabla personajes Bomba
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(68, 'Bob-omb', 1, 4, 2, 14),
(69, 'Rey Bob-omb', 5, 5, 5, 14),
(70, 'Bombette', 3, 4, 3, 14),
(71, 'Bombard', 5,3, 3, 14);

-- Elementos de la tabla personajes Judía
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES


