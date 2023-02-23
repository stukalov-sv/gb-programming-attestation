DROP DATABASE IF EXISTS `HumanFriends`;
CREATE DATABASE `HumanFriends`; 

USE `HumanFriends`;

DROP TABLE IF EXISTS animal_variants;
CREATE TABLE IF NOT EXISTS animal_variants (
  id INT UNSIGNED UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_variant VARCHAR(100) NOT NULL
);

INSERT INTO animal_variants (animal_variant)
VALUES
('Pet'),
('Pack animal');

DROP TABLE IF EXISTS animal_types;
CREATE TABLE IF NOT EXISTS animal_types (
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_type VARCHAR(45) UNIQUE NOT NULL,
  animal_variant_id INT UNSIGNED NOT NULL,
  CONSTRAINT animal_variant_id_FK FOREIGN KEY (animal_variant_id) REFERENCES animal_variants (id)
);

INSERT INTO animal_types (animal_variant_id, animal_type)
VALUES
(1, 'cat'),
(1, 'dog'),
(1, 'humster'),
(2, 'horse'),
(2, 'camel'),
(2, 'donkey');

DROP TABLE IF EXISTS animals;
CREATE TABLE IF NOT EXISTS animals (
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_type_id INT UNSIGNED NOT NULL,
  animal_name VARCHAR(100) NOT NULL,
  birth_date DATE NOT NULL,
  `action` VARCHAR(45),
  CONSTRAINT animal_type_id_FK FOREIGN KEY (animal_type_id) REFERENCES animal_types (id)
);

INSERT INTO animals (animal_name, animal_type_id, birth_date, `action`)
VALUES
	('Cat1', '1', '2021-12-12', 'meow'),
	('Cat2', '1', '2022-11-11', 'meow'),
	('Dog1', '2', '2019-10-10', 'woof'),
	('Dog2', '2', '2020-09-09', 'woof'),
	('Humster1', '3', '2022-08-08', 'scranch'),
	('Horse1', '4', '2018-07-07', 'neigh'),
	('Horse2', '4', '2015-06-06', 'neigh'),
	('Camel1', '5', '2020-05-05', 'prrr'),
	('Camel2', '5', '2013-04-04', 'prrr'),
	('Donkey1', '6', '2021-03-03', 'eeyore'),
	('Donkey2', '6', '2017-02-02', 'eeyore');
    
SELECT * FROM animals;