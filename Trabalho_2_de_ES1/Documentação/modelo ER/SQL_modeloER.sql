-- MySQL Workbench Synchronization
-- Generated: 2019-09-04 19:34
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: hanna

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `ClinicaMedica` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`TipoLogradouro` (
  `idtplogradouro` INT(11) NOT NULL,
  `nometplog` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`idtplogradouro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Logradouro` (
  `idLogradouro` INT(11) NOT NULL,
  `nomelog` VARCHAR(45) NULL DEFAULT NULL,
  `idtplogradouro` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idLogradouro`),
  INDEX `idtplogradouro_idx` (`idtplogradouro` ASC),
  CONSTRAINT `idtplogradouro`
    FOREIGN KEY (`idtplogradouro`)
    REFERENCES `ClinicaMedica`.`TipoLogradouro` (`idtplogradouro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Bairro` (
  `idBairro` INT(11) NOT NULL,
  `nomebairro` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idBairro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Pais` (
  `idPais` INT(11) NOT NULL,
  `nomepais` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idPais`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`UF` (
  `sigla` VARCHAR(2) NOT NULL,
  `nomeuf` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`sigla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Endereco` (
  `idEndereco` INT(11) NOT NULL,
  `cep` INT(11) NULL DEFAULT NULL,
  `idLogradouro` INT(11) NULL DEFAULT NULL,
  `idCidade` INT(11) NULL DEFAULT NULL,
  `idBairro` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idEndereco`),
  INDEX `idCidade_idx` (`idCidade` ASC),
  INDEX `idLogradouro_idx` (`idLogradouro` ASC),
  INDEX `idBairro_idx` (`idBairro` ASC),
  CONSTRAINT `idCidade`
    FOREIGN KEY (`idCidade`)
    REFERENCES `ClinicaMedica`.`Cidade` (`idCidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idLogradouro`
    FOREIGN KEY (`idLogradouro`)
    REFERENCES `ClinicaMedica`.`Logradouro` (`idLogradouro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idBairro`
    FOREIGN KEY (`idBairro`)
    REFERENCES `ClinicaMedica`.`Bairro` (`idBairro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Cidade` (
  `idCidade` INT(11) NOT NULL,
  `nomeCid` VARCHAR(45) NULL DEFAULT NULL,
  `sigla` VARCHAR(2) NULL DEFAULT NULL,
  `idPais` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idCidade`),
  INDEX `idPais_idx` (`idPais` ASC),
  INDEX `sigla_idx` (`sigla` ASC),
  CONSTRAINT `idPais`
    FOREIGN KEY (`idPais`)
    REFERENCES `ClinicaMedica`.`Pais` (`idPais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sigla`
    FOREIGN KEY (`sigla`)
    REFERENCES `ClinicaMedica`.`UF` (`sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Paciente` (
  `idPaciente` INT(11) NOT NULL,
  `nomePaciente` VARCHAR(45) NULL DEFAULT NULL,
  `rgPaciente` VARCHAR(14) NULL DEFAULT NULL,
  `cpfPaciente` VARCHAR(15) NULL DEFAULT NULL,
  `dtNascPaciente` VARCHAR(11) NULL DEFAULT NULL,
  `nroEndPacinte` INT(11) NULL DEFAULT NULL,
  `compEndPaciente` VARCHAR(45) NULL DEFAULT NULL,
  `idEndereco` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idPaciente`),
  INDEX `idEndereco_idx` (`idEndereco` ASC),
  CONSTRAINT `idEndereco`
    FOREIGN KEY (`idEndereco`)
    REFERENCES `ClinicaMedica`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`DDD` (
  `ddd` INT(11) NOT NULL,
  PRIMARY KEY (`ddd`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Fone` (
  `idFone` INT(11) NOT NULL,
  `idCliente` INT(11) NULL DEFAULT NULL,
  `ddd` INT(11) NULL DEFAULT NULL,
  `numero` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idFone`),
  INDEX `idCliente_idx` (`idCliente` ASC),
  INDEX `ddd_idx` (`ddd` ASC),
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `ClinicaMedica`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ddd`
    FOREIGN KEY (`ddd`)
    REFERENCES `ClinicaMedica`.`DDD` (`ddd`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Medico` (
  `crm` INT(11) NOT NULL,
  `nomeMedico` VARCHAR(45) NULL DEFAULT NULL,
  `numEndMedico` VARCHAR(45) NULL DEFAULT NULL,
  `compEndMedico` VARCHAR(45) NULL DEFAULT NULL,
  `rgMedico` VARCHAR(15) NULL DEFAULT NULL,
  `cpfMedico` VARCHAR(15) NULL DEFAULT NULL,
  `dtNascMedico` VARCHAR(12) NULL DEFAULT NULL,
  PRIMARY KEY (`crm`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`TipoConsulta` (
  `idTpConsulta` INT(11) NOT NULL,
  `nomeTpConsulta` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idTpConsulta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`CIDConsulta` (
  `idCID` INT(11) NOT NULL,
  `nomeCID` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Consulta` (
  `idConsulta` INT(11) NOT NULL,
  `dtConsulta` DATE NULL DEFAULT NULL,
  `idCID` INT(11) NULL DEFAULT NULL,
  `idTpConsulta` INT(11) NULL DEFAULT NULL,
  `idPaciente` INT(11) NULL DEFAULT NULL,
  `crmMedico` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idConsulta`),
  INDEX `idCID_idx` (`idCID` ASC),
  INDEX `idTpConsulta_idx` (`idTpConsulta` ASC),
  INDEX `idPaciente_idx` (`idPaciente` ASC),
  INDEX `crmMedico_idx` (`crmMedico` ASC),
  CONSTRAINT `idCID`
    FOREIGN KEY (`idCID`)
    REFERENCES `ClinicaMedica`.`CIDConsulta` (`idCID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTpConsulta`
    FOREIGN KEY (`idTpConsulta`)
    REFERENCES `ClinicaMedica`.`TipoConsulta` (`idTpConsulta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPaciente`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `ClinicaMedica`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `crmMedico`
    FOREIGN KEY (`crmMedico`)
    REFERENCES `ClinicaMedica`.`Medico` (`crm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`GuiaExame` (
  `idGuiaExame` INT(11) NOT NULL,
  `dtExame` DATE NULL DEFAULT NULL,
  `crmMedico` INT(11) NULL DEFAULT NULL,
  `idPaciente` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idGuiaExame`),
  INDEX `crmMedico_idx` (`crmMedico` ASC),
  INDEX `idPaciente_idx` (`idPaciente` ASC),
  CONSTRAINT `crmMedico`
    FOREIGN KEY (`crmMedico`)
    REFERENCES `ClinicaMedica`.`Medico` (`crm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPaciente`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `ClinicaMedica`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`ExameResultado` (
  `idExameResultado` INT(11) NOT NULL,
  `nomeExameResultado` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idExameResultado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Exame` (
  `idExame` INT(11) NOT NULL,
  `descricaoExame` VARCHAR(45) NULL DEFAULT NULL,
  `idExameResultado` INT(11) NULL DEFAULT NULL,
  `idGuiaExame` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idExame`),
  INDEX `idExameMedico_idx` (`idExameResultado` ASC),
  INDEX `idGuiaExame_idx` (`idGuiaExame` ASC),
  CONSTRAINT `idExameResultado`
    FOREIGN KEY (`idExameResultado`)
    REFERENCES `ClinicaMedica`.`ExameResultado` (`idExameResultado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idGuiaExame`
    FOREIGN KEY (`idGuiaExame`)
    REFERENCES `ClinicaMedica`.`GuiaExame` (`idGuiaExame`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`Remedio` (
  `idRemedio` INT(11) NOT NULL,
  `nomeRemedio` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idRemedio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`RemedioPasologia` (
  `idRemedioPasologia` INT(11) NOT NULL,
  `RemedioPasologia` VARCHAR(45) NULL DEFAULT NULL,
  `dias` INT(11) NULL DEFAULT NULL,
  `idRemedio` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idRemedioPasologia`),
  INDEX `idRemedio_idx` (`idRemedio` ASC),
  CONSTRAINT `idRemedio`
    FOREIGN KEY (`idRemedio`)
    REFERENCES `ClinicaMedica`.`Remedio` (`idRemedio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ClinicaMedica`.`ReceitaMedica` (
  `idReceitaMedica` INT(11) NOT NULL,
  `dataReceita` DATE NULL DEFAULT NULL,
  `nroReceita` INT(11) NULL DEFAULT NULL,
  `crmMedico` INT(11) NULL DEFAULT NULL,
  `idPaciente` INT(11) NULL DEFAULT NULL,
  `idRemedioPosologia` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idReceitaMedica`),
  INDEX `idMedico_idx` (`crmMedico` ASC),
  INDEX `idPaciente_idx` (`idPaciente` ASC),
  INDEX `idRemedioPosologia_idx` (`idRemedioPosologia` ASC),
  CONSTRAINT `crmMedico`
    FOREIGN KEY (`crmMedico`)
    REFERENCES `ClinicaMedica`.`Medico` (`crm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPaciente`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `ClinicaMedica`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idRemedioPosologia`
    FOREIGN KEY (`idRemedioPosologia`)
    REFERENCES `ClinicaMedica`.`RemedioPasologia` (`idRemedioPasologia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
