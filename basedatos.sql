CREATE DATABASE IF NOT EXISTS `veterinaria`;
USE `veterinaria`;

DROP TABLE IF EXISTS `especie`;
CREATE TABLE `especie` (
  `id_especie` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_especie`)
);
INSERT INTO `especie` VALUES (1, 'Perro');
INSERT INTO `especie` VALUES (2, 'Gato');
INSERT INTO `especie` VALUES (3, 'Caballo');

DROP TABLE IF EXISTS `raza`;
CREATE TABLE `raza` (
  `id_raza` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `id_especie` int NOT NULL,
  PRIMARY KEY (`id_raza`),
  KEY `raza_especie_fk` (`id_especie`),
  CONSTRAINT `raza_especie_fk` FOREIGN KEY (`id_especie`) REFERENCES `especie` (`id_especie`)
);
INSERT INTO `raza` VALUES (1, 'Golden Retriever', 1);
INSERT INTO `raza` VALUES (2, 'Pastor americano', 1);
INSERT INTO `raza` VALUES (3, 'Lobero irlandés', 1);
INSERT INTO `raza` VALUES (4, 'Persa', 2);
INSERT INTO `raza` VALUES (5, 'Andaluz', 3);

DROP TABLE IF EXISTS `dueno`;
CREATE TABLE `dueno` (
  `id_dueno` int NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(30) DEFAULT NULL,
  `nombres` varchar(30) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_dueno`)
);
INSERT INTO `dueno` VALUES (1, 'Fatama Vera', 'Jorge', '+51937142836', 'Av. Universitaria 1801 San Miguel');
INSERT INTO `dueno` VALUES (2, 'Perez Ugarte', 'Juan', '+51999999999', 'Av. La Marina 1695 San Miguel');

DROP TABLE IF EXISTS `mascota`;
CREATE TABLE `mascota` (
  `id_mascota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `id_raza` int DEFAULT NULL,
  `id_dueno` int NOT NULL,
  PRIMARY KEY (`id_mascota`),
  KEY `mascota_raza_fk` (`id_raza`),
  KEY `mascota_dueno_fk` (`id_dueno`),
  CONSTRAINT `mascota_raza_fk` FOREIGN KEY (`id_raza`) REFERENCES `raza` (`id_raza`),
  CONSTRAINT `mascota_dueno_fk` FOREIGN KEY (`id_dueno`) REFERENCES `dueno` (`id_dueno`)
);
INSERT INTO `mascota` VALUES (1, 'Pelusa', 1, 1);
INSERT INTO `mascota` VALUES (2, 'Quilla', 2, 1);
INSERT INTO `mascota` VALUES (3, 'Perdida', 2, 1);
INSERT INTO `mascota` VALUES (4, 'Clarita', 3, 1);  
INSERT INTO `mascota` VALUES (5, 'Fluffy', 4, 2);
INSERT INTO `mascota` VALUES (6, 'Cupido', 5, 2);
INSERT INTO `mascota` VALUES (7, 'Joya', 5, 2);