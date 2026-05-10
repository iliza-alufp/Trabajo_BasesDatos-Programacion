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
(21, 'Kremling'),
(22, 'Insecto');

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
(9, 'Donkey Kong', 6, 7, 7, 15),
(10, 'Diddy Kong', 3, 4, 3, 15),
(11, 'Dixie Kong', 4, 3, 3, 15),
(12, 'Cranky Kong', 3, 2, 3, 15);

-- Elementos de la tabla personajes Toad
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(13, 'Toad', 2, 1, 1, 4),
(14, 'Toadette', 4, 3, 3, 4),
(15, 'Maestro Kinopio', 3, 3, 3, 4),
(16, 'Capitán Toad', 4, 4, 3, 4),

-- Elementos de la tabla personajes Koopa
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(17, 'Koopa Troopa', 2, 1, 1, 2),
(18, 'Koopa Paratroopa', 3, 1, 1, 2),
(19, 'Huesitos', 1, 1, 3, 2),
(20, 'Hammer Bro', 3, 4, 3, 2),
(21, 'Lakitu', 3, 2, 4, 2),
(22, 'Pinchón', 1, 3, 2, 2),
(23, 'Buzzy Beetle', 4, 1, 2, 2),
(24, 'Bowser', 8, 8, 7, 2),
(25, 'Bowsy', 6, 4, 4, 2),
(26, 'Larry', 4, 4, 4, 2),
(27, 'Morton', 4, 5, 4, 2),
(28, 'Wendy', 4, 3, 4, 2),
(29, 'Iggy', 4, 4, 4, 2),
(30, 'Roy', 4, 6, 4, 2),
(31, 'Lemmy', 4, 1, 4, 2),
(32, 'Ludwig', 4, 7, 4, 2),
(33, 'Boom Boom', 3, 4, 3),
(34, 'Pom Pom', 4, 3, 3),
(35, 'Bowsitos', 8, 8, 7, 2),
(36, 'Spike', 2, 5, 3, 2),
(37, 'Kamek', 4, 2, 3, 2),
(38, 'Mechakoopa', 2, 2, 2, 2),
(39, 'Kooper', 3, 4, 3, 2),
(40, 'Parakarry', 4, 5, 3, 2),
(41, 'Koops', 5, 3, 3, 2),
(42, 'Lakilester', 4, 3, 3, 2),
(43, 'Kammy', 4, 2, 3, 2),
(44, 'Placapum', 6, 2, 4, 2);

-- Elementos de la tabla personajes Goomba
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(45, 'Goomba', 1, 1, 0, 3),
(46, 'Rey Goomba', 5, 3, 4, 3),
(47, 'Goombario', 3, 4, 3, 3),
(48, 'Goomarina', 3, 5, 3, 3);

-- Elementos de la tabla personajes Planta
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(49, 'Planta Piraña', 1, 4, 3, 5),
(50, 'Floro Piraña', 5, 5, 4, 5),
(51, 'Floruga', 3, 3, 3, 5),
(52, 'Forestano', 4, 2, 3, 5),
(53, 'Pokey', 6, 2, 4, 5);

-- Elementos de la tabla personajes Fantasma
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(54, 'Boo', 4, 1, 2, 6),
(55, 'Rey Boo', 7, 8, 6, 6),
(56, 'Lady Bow', 3, 4, 3, 6)
(57, 'Claudia', 5, 3, 3, 6),
(58, 'Bibiana', 4, 5, 3, 6),
(59, 'Boo Bomba', 2, 1, 3, 6),
(60, 'Reina de las Sombras', 9, 6, 7, 6),
(61, 'Fantasmirón', 4, 1, 2, 6);

-- Elementos de la tabla personajes Dinosaurio
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(62, 'Yoshi', 5, 5, 4, 7),
(63, 'Birdo', 4, 5, 4, 7),
(64, 'Reznor', 4, 4, 4, 7);

-- Elementos de la tabla personajes Rana
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(65, 'Wart', 7, 7, 6, 8),
(66, 'Monerrana', 3, 2, 3, 8);

-- Elementos de la tabla personajes Ratón
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(67, 'Mouser', 4, 5, 4, 9),
(68, 'Lupina', 4, 4, 3, 9);

-- Elementos de la tabla personajes Cangrejo
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(69, 'Clawglip', 4, 5, 4, 10),
(70, 'Sidestepper', 2, 2, 2, 10);

-- Elementos de la tabla personajes Topo
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(71, 'Monty', 1, 2, 1, 11),
(72, 'Tortopo', 2, 3, 2, 11);

-- Elementos de la tabla personajes Estrella
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(73, 'Destello', 1, 3, 2, 12),
(74, 'Nebu', 2, 3, 2, 12),
(75, 'Lubba', 3, 3, 3, 12);

-- Elementos de la tabla personajes Hey-Ho
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(76, 'Shy Guy', 2, 1, 1, 13);

-- Elementos de la tabla personajes Bomba
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(77, 'Bob-omb', 1, 4, 2, 14),
(78, 'Rey Bob-omb', 5, 5, 5, 14),
(79, 'Bombette', 3, 4, 3, 14),
(80, 'Bombard', 5,3, 3, 14);

-- Elementos de la tabla personajes Judía
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(81, 'Cackletta', 7, 6, 6, 15),
(82, 'Grácovitz', 8, 9, 7, 15);

-- Elementos de la tabla personajes Conejo
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(83, 'Caco Gazapo', 3, 4, 3, 16);

-- Elementos de la tabla personajes Pez
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(84, 'Cheep Cheep', 2, 1, 1, 17),
(85, 'Pezueso', 1, 3, 2, 17),
(86, 'Cheep Chomp', 3, 3, 3, 17),
(87, 'Delfín', 3, 2, 3, 17),
(88, 'Blooper', 2, 2, 2, 17),
(89, 'Gooper Blooper', 6, 6, 6, 17);

-- Elementos de la tabla personajes Ave
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(90, 'Cataquack', 4, 1, 3, 18),
(91, 'Conkdor', 2, 2, 2, 18),
(92, 'Pingüino', 2, 1, 1, 18);

-- Elementos de la tabla personajes Murciélago
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(93, 'Swoop', 2, 1, 1, 19);

-- Elementos de la tabla personajes Kremling
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(94, 'Kritter', 2, 1, 1, 20),
(95, 'Krusha', 3, 3, 3, 20),
(96, 'Klaptrap', 1, 1, 0, 20),
(97, 'Klobber', 3, 1, 2, 20),
(98, 'King K. Rool', 8, 8, 7, 20);

-- Elementos de la tabla personajes Insecto
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase) VALUES
(99, 'Abejorro', 1, 3, 1, 21),
(100, 'Marchimotas', 3, 1, 2, 21);
