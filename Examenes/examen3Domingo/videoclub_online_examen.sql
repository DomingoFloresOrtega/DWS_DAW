SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP DATABASE IF EXISTS videoclub_examen;
CREATE DATABASE videoclub_examen CHARACTER SET utf8mb4;
USE videoclub_examen;

CREATE TABLE actor (
  id_actor SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_actor),
  KEY idx_actor_apellidos (apellidos)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE direccion (
  id_direccion SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  direccion VARCHAR(50) NOT NULL,
  direccion2 VARCHAR(50),
  distrito VARCHAR(20) NOT NULL,
  id_ciudad SMALLINT UNSIGNED NOT NULL,
  codigo_postal VARCHAR(10) DEFAULT NULL,
  telefono VARCHAR(20) NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_direccion),
  KEY idx_fk_id_ciudad (id_ciudad),
  CONSTRAINT `fk_direccion_ciudad` FOREIGN KEY (id_ciudad) REFERENCES ciudad (id_ciudad) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE categoria (
  id_categoria TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(25) NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_categoria)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE ciudad (
  id_ciudad SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  id_pais SMALLINT UNSIGNED NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_ciudad),
  KEY idx_fk_id_pais (id_pais),
  CONSTRAINT `fk_ciudad_pais` FOREIGN KEY (id_pais) REFERENCES pais (id_pais) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE pais (
  id_pais SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_pais)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE cliente (
  id_cliente SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_almacen TINYINT UNSIGNED NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  email VARCHAR(50) DEFAULT NULL,
  id_direccion SMALLINT UNSIGNED NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT TRUE,
  fecha_creacion DATETIME NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_cliente),
  KEY idx_fk_id_almacen (id_almacen),
  KEY idx_fk_id_direccion (id_direccion),
  KEY idx_apellidos (apellidos),
  CONSTRAINT fk_customer_address FOREIGN KEY (id_direccion) REFERENCES direccion (id_direccion) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_customer_store FOREIGN KEY (id_almacen) REFERENCES almacen (id_almacen) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE pelicula (
  id_pelicula SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(255) NOT NULL,
  descripcion TEXT DEFAULT NULL,
  anyo_lanzamiento YEAR DEFAULT NULL,
  id_idioma TINYINT UNSIGNED NOT NULL,
  id_idioma_original TINYINT UNSIGNED DEFAULT NULL,
  duracion_alquiler TINYINT UNSIGNED NOT NULL DEFAULT 3,
  rental_rate DECIMAL(4,2) NOT NULL DEFAULT 4.99,
  duracion SMALLINT UNSIGNED DEFAULT NULL,
  replacement_cost DECIMAL(5,2) NOT NULL DEFAULT 19.99,
  clasificacion ENUM('G','PG','PG-13','R','NC-17') DEFAULT 'G',
  caracteristicas_especiales SET('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') DEFAULT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_pelicula),
  KEY idx_fk_id_idioma (id_idioma),
  KEY idx_fk_id_idioma_original (id_idioma_original),
  CONSTRAINT fk_film_idioma FOREIGN KEY (id_idioma) REFERENCES idioma (id_idioma) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_film_idioma_original FOREIGN KEY (id_idioma_original) REFERENCES idioma (id_idioma) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE pelicula_actor (
  id_actor SMALLINT UNSIGNED NOT NULL,
  id_pelicula SMALLINT UNSIGNED NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_actor, id_pelicula),
  CONSTRAINT fk_film_actor_actor FOREIGN KEY (id_actor) REFERENCES actor (id_actor) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_film_actor_film FOREIGN KEY (id_pelicula) REFERENCES pelicula (id_pelicula) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE pelicula_categoria (
  id_pelicula SMALLINT UNSIGNED NOT NULL,
  id_categoria TINYINT UNSIGNED NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id_pelicula, id_categoria),
  CONSTRAINT fk_film_category_film FOREIGN KEY (id_pelicula) REFERENCES pelicula (id_pelicula) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_film_category_category FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE film_text (
  film_id SMALLINT NOT NULL,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  PRIMARY KEY  (film_id),
  FULLTEXT KEY idx_title_description (title,description)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE inventario (
  id_inventario MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_pelicula SMALLINT UNSIGNED NOT NULL,
  id_almacen TINYINT UNSIGNED NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_inventario),
  KEY idx_fk_film_id (id_pelicula),
  KEY idx_store_id_film_id (id_almacen, id_pelicula),
  CONSTRAINT fk_inventory_store FOREIGN KEY (id_almacen) REFERENCES almacen (id_almacen) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_inventory_film FOREIGN KEY (id_pelicula) REFERENCES pelicula (id_pelicula) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE idioma (
  id_idioma TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre CHAR(20) NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id_idioma)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE pago (
  id_pago SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_cliente SMALLINT UNSIGNED NOT NULL,
  id_empleado TINYINT UNSIGNED NOT NULL,
  id_alquiler INT DEFAULT NULL,
  total DECIMAL(5,2) NOT NULL,
  fecha_pago DATETIME NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_pago),
  KEY idx_fk_staff_id (id_empleado),
  KEY idx_fk_customer_id (id_cliente),
  CONSTRAINT fk_payment_rental FOREIGN KEY (id_alquiler) REFERENCES alquiler (id_alquiler) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT fk_payment_customer FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_payment_staff FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE alquiler (
  id_alquiler INT NOT NULL AUTO_INCREMENT,
  fecha_alquiler DATETIME NOT NULL,
  id_inventario MEDIUMINT UNSIGNED NOT NULL,
  id_cliente SMALLINT UNSIGNED NOT NULL,
  fecha_devolucion DATETIME DEFAULT NULL,
  id_empleado TINYINT UNSIGNED NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id_alquiler),
  UNIQUE KEY  (fecha_alquiler, id_inventario, id_cliente),
  KEY idx_fk_inventory_id (id_inventario),
  KEY idx_fk_customer_id (id_cliente),
  KEY idx_fk_staff_id (id_empleado),
  CONSTRAINT fk_rental_staff FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_rental_inventory FOREIGN KEY (id_inventario) REFERENCES inventario (id_inventario) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_rental_customer FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE empleado (
  id_empleado TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  id_direccion SMALLINT UNSIGNED NOT NULL,
  imagen BLOB DEFAULT NULL,
  email VARCHAR(50) DEFAULT NULL,
  id_almacen TINYINT UNSIGNED NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT TRUE,
  username VARCHAR(16) NOT NULL,
  password VARCHAR(40) BINARY DEFAULT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_empleado),
  KEY idx_fk_store_id (id_almacen),
  KEY idx_fk_address_id (id_direccion),
  CONSTRAINT fk_staff_store FOREIGN KEY (id_almacen) REFERENCES almacen (id_almacen) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_staff_address FOREIGN KEY (id_direccion) REFERENCES direccion (id_direccion) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE almacen (
  id_almacen TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  id_empleado_jefe TINYINT UNSIGNED NOT NULL,
  id_direccion SMALLINT UNSIGNED NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (id_almacen),
  UNIQUE KEY idx_unique_manager (id_empleado_jefe),
  KEY idx_fk_address_id (id_direccion),
  CONSTRAINT fk_store_staff FOREIGN KEY (id_empleado_jefe) REFERENCES empleado (id_empleado) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT fk_store_address FOREIGN KEY (id_direccion) REFERENCES direccion (id_direccion) ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
