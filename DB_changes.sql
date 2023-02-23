USE `HumanFriends`;

DELETE FROM animals a
WHERE a.animal_type_id = (
	SELECT id 
	FROM animal_types an
	WHERE an.animal_type = 'camel');
    
SELECT * FROM animals;
	
DROP TABLE IF EXISTS `horses_&_donkeys`;
CREATE TABLE `horses_&_donkeys` (
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_type_id INT UNSIGNED NOT NULL,
  animal_name VARCHAR(100) NOT NULL,
  birth_date DATE NOT NULL,
  `action` VARCHAR(45),
  CONSTRAINT had_type_id_FK FOREIGN KEY (animal_type_id) REFERENCES animal_types (id)
);

INSERT INTO `horses_&_donkeys`
SELECT * FROM animals 
WHERE animal_type_id = (SELECT id FROM animal_types WHERE animal_type = 'horse')
OR animal_type_id = (SELECT id FROM animal_types WHERE animal_type = 'donkey');

SELECT * FROM `horses_&_donkeys`;

DROP TABLE IF EXISTS `young_animals`;
CREATE TABLE `young_animals` (
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_type_id INT UNSIGNED NOT NULL,
  animal_name VARCHAR(100) NOT NULL,
  birth_date DATE NOT NULL,
  `action` VARCHAR(45),
  months_old INT NOT NULL,
  CONSTRAINT young_type_id_FK FOREIGN KEY (animal_type_id) REFERENCES animal_types (id)
);

INSERT INTO `young_animals`
SELECT a.*, PERIOD_DIFF(DATE_FORMAT(CURRENT_DATE, '%y%m'), DATE_FORMAT(birth_date, '%y%m')) - 
	(DATE_FORMAT(CURRENT_DATE, '%d') < DATE_FORMAT(birth_date, '%d'))
	AS months
FROM animals a 
WHERE TIMESTAMPDIFF(MONTH, birth_date, now()) > 12
AND TIMESTAMPDIFF(MONTH, birth_date, now()) <= 36;

SELECT * FROM `young_animals`;

DROP TABLE IF EXISTS `result_table`;
CREATE TABLE `result_table` (
  id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  animal_type_id INT UNSIGNED NOT NULL,
  animal_name VARCHAR(100) NOT NULL,
  birth_date DATE NOT NULL,
  `action` VARCHAR(45),
  months_old INT NOT NULL,
  table_name VARCHAR(100) NOT NULL,
  CONSTRAINT comb_type_id_FK FOREIGN KEY (animal_type_id) REFERENCES animal_types (id)
);

INSERT INTO `result_table` (animal_name, birth_date, animal_type_id, `action`, months_old, table_name)
SELECT 
	animal_name, 
	birth_date, 
	animal_type_id, 
	`action`,
	TIMESTAMPDIFF(MONTH, birth_date, now()) AS months_old, 
	'animals' AS table_name FROM `animals` 
UNION ALL
SELECT 
	animal_name, 
	birth_date, 
	animal_type_id, 
	`action`,
	TIMESTAMPDIFF(MONTH, birth_date, now()) AS months_old, 
	'horses_&_donkeys' AS table_name FROM `horses_&_donkeys`
UNION ALL
SELECT 
	animal_name, 
	birth_date, 
	animal_type_id, 
	`action`,
	TIMESTAMPDIFF(MONTH, birth_date, now()) AS months_old, 
	'young_animals' AS table_name FROM `young_animals`;
    
SELECT * FROM `result_table`;