CREATE DATABASE MarioCartas;

USE MarioCartas;





-- Tabla de las clases
CREATE TABLE IF NOT EXISTS clases (

id_clase INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20)

);
/*
-- Tabla de las habilidades

CREATE TABLE IF NOT EXISTS habilidades (

id_habilidad INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20),
descripcion VARCHAR(50)

);
*/
-- Tabla de los objetos

CREATE TABLE IF NOT EXISTS efectos (
id_efecto INT AUTO_INCREMENT PRIMARY KEY,
efecto VARCHAR(100),
ataque_aumentado INT,
ataque INT,
vida_aumentada INT,
vida_disminuida INT
);

CREATE TABLE IF NOT EXISTS objetos (

id_objeto INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50),
coste INT,
id_efecto INT,
descripcion VARCHAR(100),
FOREIGN KEY (id_efecto) REFERENCES efectos (id_efecto) ON DELETE CASCADE
);

-- Tabla de los personajes
CREATE TABLE IF NOT EXISTS personajes (

id_personaje INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20),
vida INT,
ataque INT,
coste INT,
id_clase INT,
id_objeto INT,
/*id_habilidad INT,*/
FOREIGN KEY (id_clase) REFERENCES clases (id_clase),
FOREIGN KEY (id_objeto) REFERENCES objetos (id_objeto)
/*FOREIGN KEY (id_habilidad) REFERENCES habilidades (id_habilidad) ON DELETE CASCADE*/
);

CREATE TABLE IF NOT EXISTS usuarios (
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
contrasenya VARCHAR(20)
  );

CREATE TABLE IF NOT EXISTS mazo (
id_mazo INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
id_usuario INT,
FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
  );

CREATE TABLE IF NOT EXISTS cartas_mazo (
id_mazo INT,
id_personaje INT,
PRIMARY KEY (id_mazo, id_personaje),
FOREIGN KEY (id_mazo) REFERENCES mazo (id_mazo) ON DELETE CASCADE,
FOREIGN KEY (id_personaje) REFERENCES personajes (id_personaje) ON DELETE CASCADE
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
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(1, 'Mario', 7, 6, 5, 1, null),
(2, 'Luigi', 6, 7, 5, 1, null),
(3, 'Peach', 7, 4, 5, 1, null),
(4, 'Daisy', 7, 4, 5, 1, null),
(5, 'Estela', 5, 7, 5, 1, null),
(6, 'Pauline', 6, 5, 5, 1, null),
(7, 'Wario', 9, 7, 8, 1, null),
(8, 'Waluigi', 3, 2, 5, 1, null);

-- Elementos de la tabla personajes Kong
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(9, 'Donkey Kong', 6, 7, 7, 15, null),
(10, 'Diddy Kong', 3, 4, 3, 15, null),
(11, 'Dixie Kong', 4, 3, 3, 15, null),
(12, 'Cranky Kong', 3, 2, 3, 15, null);

-- Elementos de la tabla personajes Toad
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(13, 'Toad', 2, 1, 1, 4, null),
(14, 'Toadette', 4, 3, 3, 4, null),
(15, 'Maestro Kinopio', 3, 3, 3, 4, null),
(16, 'Capitán Toad', 4, 4, 3, 4, null);

-- Elementos de la tabla personajes Koopa
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(17, 'Koopa Troopa', 2, 1, 1, 2, null),
(18, 'Koopa Paratroopa', 3, 1, 1, 2, null),
(19, 'Huesitos', 1, 1, 3, 2, null),
(20, 'Hammer Bro', 3, 4, 3, 2, null),
(21, 'Lakitu', 3, 2, 4, 2, null),
(22, 'Pinchón', 1, 3, 2, 2, null),
(23, 'Buzzy Beetle', 4, 1, 2, 2, null),
(24, 'Bowser', 8, 8, 7, 2, null),
(25, 'Bowsy', 6, 4, 4, 2, null),
(26, 'Larry', 4, 4, 4, 2, null),
(27, 'Morton', 4, 5, 4, 2, null),
(28, 'Wendy', 4, 3, 4, 2, null),
(29, 'Iggy', 4, 4, 4, 2, null),
(30, 'Roy', 4, 6, 4, 2, null),
(31, 'Lemmy', 4, 1, 4, 2, null),
(32, 'Ludwig', 4, 7, 4, 2, null),
(33, 'Boom Boom', 3, 4, 3,2, null),
(34, 'Pom Pom', 4, 3, 3,2, null),
(35, 'Bowsitos', 8, 8, 7, 2, null),
(36, 'Spike', 2, 5, 3, 2, null),
(37, 'Kamek', 4, 2, 3, 2, null),
(38, 'Mechakoopa', 2, 2, 2, 2, null),
(39, 'Kooper', 3, 4, 3, 2, null),
(40, 'Parakarry', 4, 5, 3, 2, null),
(41, 'Koops', 5, 3, 3, 2, null),
(42, 'Lakilester', 4, 3, 3, 2, null),
(43, 'Kammy', 4, 2, 3, 2, null),
(44, 'Placapum', 6, 2, 4, 2, null);

-- Elementos de la tabla personajes Goomba
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(45, 'Goomba', 1, 1, 0, 3, null),
(46, 'Rey Goomba', 5, 3, 4, 3, null),
(47, 'Goombario', 3, 4, 3, 3, null),
(48, 'Goomarina', 3, 5, 3, 3, null);

-- Elementos de la tabla personajes Planta
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(49, 'Planta Piraña', 1, 4, 3, 5, null),
(50, 'Floro Piraña', 5, 5, 4, 5, null),
(51, 'Floruga', 3, 3, 3, 5, null),
(52, 'Forestano', 4, 2, 3, 5, null),
(53, 'Pokey', 6, 2, 4, 5, null);

-- Elementos de la tabla personajes Fantasma
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(54, 'Boo', 4, 1, 2, 6, null),
(55, 'Rey Boo', 7, 8, 6, 6, null),
(56, 'Lady Bow', 3, 4, 3, 6, null),
(57, 'Claudia', 5, 3, 3, 6, null),
(58, 'Bibiana', 4, 5, 3, 6, null),
(59, 'Boo Bomba', 2, 1, 3, 6, null),
(60, 'Reina de las Sombras', 9, 6, 7, 6, null),
(61, 'Fantasmirón', 4, 1, 2, 6, null);

-- Elementos de la tabla personajes Dinosaurio
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(62, 'Yoshi', 5, 5, 4, 7, null),
(63, 'Birdo', 4, 5, 4, 7, null),
(64, 'Reznor', 4, 4, 4, 7, null);

-- Elementos de la tabla personajes Rana
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(65, 'Wart', 7, 7, 6, 8, null),
(66, 'Monerrana', 3, 2, 3, 8, null);

-- Elementos de la tabla personajes Ratón
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(67, 'Mouser', 4, 5, 4, 9, null),
(68, 'Lupina', 4, 4, 3, 9, null);

-- Elementos de la tabla personajes Cangrejo
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(69, 'Clawglip', 4, 5, 4, 10, null),
(70, 'Sidestepper', 2, 2, 2, 10, null);

-- Elementos de la tabla personajes Topo
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(71, 'Monty', 1, 2, 1, 11, null),
(72, 'Tortopo', 2, 3, 2, 11, null);

-- Elementos de la tabla personajes Estrella
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(73, 'Destello', 1, 3, 2, 12, null),
(74, 'Nebu', 2, 3, 2, 12, null),
(75, 'Lubba', 3, 3, 3, 12, null);

-- Elementos de la tabla personajes Hey-Ho
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(76, 'Shy Guy', 2, 1, 1, 13, null);

-- Elementos de la tabla personajes Bomba
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(77, 'Bob-omb', 1, 4, 2, 14, null),
(78, 'Rey Bob-omb', 5, 5, 5, 14, null),
(79, 'Bombette', 3, 4, 3, 14, null),
(80, 'Bombard', 5,3, 3, 14, null);

-- Elementos de la tabla personajes Judía
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(81, 'Cackletta', 7, 6, 6, 16, null),
(82, 'Grácovitz', 8, 9, 7, 16, null);

-- Elementos de la tabla personajes Conejo
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(83, 'Caco Gazapo', 3, 4, 3, 17, null);

-- Elementos de la tabla personajes Pez
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(84, 'Cheep Cheep', 2, 1, 1, 18, null),
(85, 'Pezueso', 1, 3, 2, 18, null),
(86, 'Cheep Chomp', 3, 3, 3, 18, null),
(87, 'Delfín', 3, 2, 3, 18, null),
(88, 'Blooper', 2, 2, 2, 18, null),
(89, 'Gooper Blooper', 6, 6, 6, 18, null);

-- Elementos de la tabla personajes Ave
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(90, 'Cataquack', 4, 1, 3, 19, null),
(91, 'Conkdor', 2, 2, 2, 19, null),
(92, 'Pingüino', 2, 1, 1, 19, null);

-- Elementos de la tabla personajes Murciélago
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(93, 'Swoop', 2, 1, 1, 20, null);

-- Elementos de la tabla personajes Kremling
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(94, 'Kritter', 2, 1, 1, 21, null),
(95, 'Krusha', 3, 3, 3, 21, null),
(96, 'Klaptrap', 1, 1, 0, 21, null),
(97, 'Klobber', 3, 1, 2, 21, null),
(98, 'King K. Rool', 8, 8, 7, 21, null);

-- Elementos de la tabla personajes Insecto
INSERT INTO personajes (id_personaje, nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
(99, 'Abejorro', 1, 3, 1, 22, null),
(100, 'Marchimotas', 3, 1, 2, 22, null);

-- Elementos de la tabla efectos
INSERT INTO efectos (id_efecto, efecto, ataque_aumentado, ataque, vida_aumentada, vida_disminuida) VALUES
(1, "Aumenta la vitalidad de todo aquel que lo consuma", 1, 0, 2, 0),
(2, "Aumenta el ataque del poseedor", 4, 0, 0, 0),
(3, "Aumenta el ataque y paraliza al adversario", 3, 0, 0, 0),
(4, "Aumenta drásticamente el poder", 6, 0, 0, 0),
(5, "Aumenta el ataque", 3, 0, 0, 0),
(6, "Aumenta el ataque", 5, 0, 0, 0),
(7, "Ajo extraño que sube la vitalidad", 2, 0, 1, 0),
(8, "Misil que daña al enemigo", 0, 3, 0, 0),
(9, "Gran misil de daño masivo", 0, 5, 0, 0),
(10, "Champiñón venenoso reutilizable", 0, 0, 0, 1),
(11, "Champiñón con poderes curativos milagrosos", 0, 0, 4, 0),
(12, "Todo aquel que lo consuma vivrá su mejor estado de forma", 6, 0, 6, 0),
(13, "Extraña campana de aura gatuna", 3, 0, 0, 0);

-- Elementos de la tabla objetos
INSERT INTO objetos (id_objeto, nombre, coste, id_efecto, descripcion) VALUES
(1, "Champiñón", 3, 1, "Aumenta la vitalidad de todo aquel que lo consuma"),
(2, "Flor de fuego", 3, 2, "Aumenta el ataque del poseedor"),
(3, "Flor de hielo", 3, 3, "Aumenta el ataque y paraliza al adversario"),
(4, "Estrella", 6, 4, "Aumenta drásticamente el poder"),
(5, "Gorra toro", 3, 5, "Aumenta el ataque"),
(6, "Gorra dragón", 4, 6, "Aumenta el ataque"),
(7, "Ajo", 3, 7, "Ajo extraño que sube la vitalidad"),
(8, "Bill Bala", 2, 8, "Misil que daña al enemigo"),
(9, "Bill Banzai", 4, 9, "Gran misil de daño masivo"),
(10, "Champiñón venenoso", 2, 10, "Champiñón venenoso reutilizable"),
(11, "Vida extra", 5, 11, "Champiñón con poderes curativos milagrosos"),
(12, "Duplicereza", 7, 12, "Todo aquel que lo consuma vivrá su mejor estado de forma"),
(13, "Campana de gato", 4, 13, "Extraña campana de aura gatuna");

-- Elementos de la tabla usuarios
INSERT INTO usuarios (id_usuario, nombre, contrasenya) VALUES
(1, "Miyamoto", "Mario1234"),
(2, "Koizumi", "Majora4Ever"),
(3, "Tezuka", "Sunshine");


-- CONSULTAS
-- Número de cartas por clase
SELECT c.nombre AS CLASE, COUNT(id_personaje) AS NUMERO_PERSONAJES
FROM personajes p
JOIN clases c ON p.id_clase = c.id_clase
GROUP BY c.nombre
ORDER BY NUMERO_PERSONAJES;

-- Las 10 cartas con más vida
SELECT nombre, vida
FROM personajes
ORDER BY vida
LIMIT 10;
  
-- Las cartas con ataque superior a la media
SELECT nombre, ataque
FROM personajes
WHERE ataque > (
  SELECT AVG(ataque)
  FROM personajes
  );

-- Las 10 cartas más caras
SELECT nombre, coste
FROM personajes
ORDER BY coste
LIMIT 10;

-- PROCEDIMIENTOS Y FUNCIONES
-- Crear nuevos usuarios
DELIMITER //

CREATE PROCEDURE crear_usuario(IN p_nombre VARCHAR(30), IN p_contrasenya VARCHAR(20))

  BEGIN
   INSERT INTO usuarios(nombre, contrasenya) VALUES(p_nombre, p_contrasenya);
  END //
  
DELIMITER ;

-- Eliminar un usuario, se necesita su contraseña para poder borrarlo
DELIMITER //

  CREATE PROCEDURE eliminar_usuario(IN p_nombre VARCHAR(30), IN p_contrasenya VARCHAR(20))

  BEGIN
    DELETE FROM usuarios
    WHERE p_nombre = nombre
    AND p_contrasenya = contrasenya;
  END //
  
DELIMITER ;

-- Modificar el nombre del usuario
DELIMITER //

CREATE PROCEDURE modificar_usuario(IN p_id_usuario INT, IN nuevoNombre VARCHAR(30))

  BEGIN
    UPDATE usuarios
    SET nombre = nuevoNombre
    WHERE p_id_usuario = id_usuario;
  END //
  
DELIMITER ;

-- Crear y eliminar cartas de la base de datos
DELIMITER //

  CREATE PROCEDURE crear_carta(IN p_nombre VARCHAR(20), IN p_vida INT, IN p_ataque INT, IN p_coste INT, IN p_id_clase INT, IN p_id_objeto INT)

  BEGIN
  INSERT INTO personajes (nombre, vida, ataque, coste, id_clase, id_objeto) VALUES
  (p_nombre, p_vida, p_ataque, p_coste, p_id_clase, p_id_objeto);
  END //
  
DELIMITER ;

DELIMITER //

  CREATE PROCEDURE eliminar_carta (IN p_nombre VARCHAR(20))

  BEGIN
      DELETE FROM personajes
      WHERE nombre = p_nombre;
  END //
  
DELIMITER ;

-- Buscar cartas por nombre

DELIMITER //

CREATE PROCEDURE (IN p_nombre VARCHAR(30))

  BEGIN
    SELECT nombre, vida, ataque, coste
    FROM personajes
  WHERE p_nombre = nombre;
  END //
  
DELIMITER ;
