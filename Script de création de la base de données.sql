CREATE DATABASE IF NOT EXISTS `appareilphoto`;

CREATE TABLE IF NOT EXISTS `appareilphoto`.`Type` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `appareilphoto`.`Marque` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `Nom` VARCHAR(45) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `appareilphoto`.`Modele` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL DEFAULT NULL,
  `marque` INT UNSIGNED NOT NULL,
  CONSTRAINT `fk_Modele_Marque1`
    FOREIGN KEY (`marque`)
    REFERENCES `appareilphoto`.`Marque` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `appareilphoto`.`Appareil` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `Photo` MEDIUMBLOB NULL DEFAULT NULL,
  `ModeEmploie` MEDIUMBLOB NULL DEFAULT NULL,
  `type` INT UNSIGNED NOT NULL,
  `Modele` INT UNSIGNED NOT NULL,
  CONSTRAINT `fk_Appareil_Type`
    FOREIGN KEY (`type`)
    REFERENCES `appareilphoto`.`Type` (`id`),    
  CONSTRAINT `fk_Appareil_Modele1`
    FOREIGN KEY (`Modele`)
    REFERENCES `appareilphoto`.`Modele` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;