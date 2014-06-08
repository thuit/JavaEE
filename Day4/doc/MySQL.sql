CREATE TABLE `test`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `cities` VARCHAR(45) NULL,
  `hobbies` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `test`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `press` VARCHAR(45) NULL,
  `picture` VARCHAR(45) NULL,
  `date` DATE NULL,
  `price` DOUBLE(6,2) NULL,
  `amount` INT NULL,
  PRIMARY KEY (`id`));

