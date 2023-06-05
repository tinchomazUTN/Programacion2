-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Consultora
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Consultora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Consultora` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
USE `Consultora` ;

-- -----------------------------------------------------
-- Table `Consultora`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultora`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `precioHora` INT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultora`.`programador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultora`.`programador` (
  `idprogramador` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `domicilio` VARCHAR(45) NULL,
  `dni` INT NULL,
  `tiempoTrabajado` DECIMAL(10,2) NULL,
  `cliente` INT NULL,
  `tiempoTrabajadoTotal` INT NULL,
  PRIMARY KEY (`idprogramador`),
  INDEX `fk_programador_cliente1_idx` (`cliente` ASC) VISIBLE,
  CONSTRAINT `fk_programador_cliente1`
    FOREIGN KEY (`cliente`)
    REFERENCES `Consultora`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultora`.`analista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultora`.`analista` (
  `idanalista` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `domicilio` VARCHAR(45) NULL,
  `dni` INT NULL,
  `categoria` VARCHAR(45) NULL,
  PRIMARY KEY (`idanalista`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultora`.`sueldoMes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Consultora`.`sueldoMes` (
  `idsueldoMes` INT NOT NULL AUTO_INCREMENT,
  `enero` INT NULL,
  `febrero` INT NULL,
  `marzo` INT NULL,
  `abril` INT NULL,
  `mayo` INT NULL,
  `junio` INT NULL,
  `julio` INT NULL,
  `agosto` INT NULL,
  `septiembre` INT NULL,
  `octubre` INT NULL,
  `noviembre` INT NULL,
  `diciembre` INT NULL,
  `anio` INT NULL,
  `idprogramador` INT NULL,
  `idanalista` INT NULL,
  PRIMARY KEY (`idsueldoMes`),
  INDEX `fk_sueldoMes_programador1_idx` (`idprogramador` ASC) VISIBLE,
  INDEX `fk_sueldoMes_analista1_idx` (`idanalista` ASC) VISIBLE,
  CONSTRAINT `fk_sueldoMes_programador1`
    FOREIGN KEY (`idprogramador`)
    REFERENCES `Consultora`.`programador` (`idprogramador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sueldoMes_analista1`
    FOREIGN KEY (`idanalista`)
    REFERENCES `Consultora`.`analista` (`idanalista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
