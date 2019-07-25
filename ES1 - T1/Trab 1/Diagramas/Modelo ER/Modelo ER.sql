-- MySQL Workbench Synchronization
-- Generated: 2019-05-03 15:12
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Gabriel

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `identificarProduto` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`Produto` (
  `idProduto` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeProduto` VARCHAR(45) NULL DEFAULT NULL,
  `valorVenda` FLOAT(11) NULL DEFAULT NULL,
  `valorCusto` FLOAT(11) NULL DEFAULT NULL,
  `idorigemProduto` INT(11) NOT NULL,
  `idstatusProduto` INT(11) NOT NULL,
  `idtipoProduto` INT(11) NOT NULL,
  `idfornecedor` INT(11) NOT NULL,
  PRIMARY KEY (`idProduto`),
  INDEX `fk_Produto_origemProduto_idx` (`idorigemProduto` ASC),
  INDEX `fk_Produto_statusProduto1_idx` (`idstatusProduto` ASC),
  INDEX `fk_Produto_tipoProduto1_idx` (`idtipoProduto` ASC),
  INDEX `fk_Produto_fornecedor1_idx` (`idfornecedor` ASC),
  CONSTRAINT `fk_Produto_origemProduto`
    FOREIGN KEY (`idorigemProduto`)
    REFERENCES `identificarProduto`.`origemProduto` (`idorigemProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_statusProduto1`
    FOREIGN KEY (`idstatusProduto`)
    REFERENCES `identificarProduto`.`statusProduto` (`idstatusProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_tipoProduto1`
    FOREIGN KEY (`idtipoProduto`)
    REFERENCES `identificarProduto`.`tipoProduto` (`idtipoProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_fornecedor1`
    FOREIGN KEY (`idfornecedor`)
    REFERENCES `identificarProduto`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`statusProduto` (
  `idstatusProduto` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeStatusProduto` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idstatusProduto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`origemProduto` (
  `idorigemProduto` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeOrigemProduto` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idorigemProduto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`tipoProduto` (
  `idtipoProduto` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeTipoProduto` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idtipoProduto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`endereço` (
  `idendereço` INT(11) NOT NULL AUTO_INCREMENT,
  `CEP` VARCHAR(9) NULL DEFAULT NULL,
  `idlogradouro` INT(11) NOT NULL,
  `idbairro` INT(11) NOT NULL,
  `idcidade` INT(11) NOT NULL,
  PRIMARY KEY (`idendereço`),
  INDEX `fk_endereço_logradouro1_idx` (`idlogradouro` ASC),
  INDEX `fk_endereço_bairro1_idx` (`idbairro` ASC),
  INDEX `fk_endereço_cidade1_idx` (`idcidade` ASC),
  CONSTRAINT `fk_endereço_logradouro1`
    FOREIGN KEY (`idlogradouro`)
    REFERENCES `identificarProduto`.`logradouro` (`idlogradouro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereço_bairro1`
    FOREIGN KEY (`idbairro`)
    REFERENCES `identificarProduto`.`bairro` (`idbairro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereço_cidade1`
    FOREIGN KEY (`idcidade`)
    REFERENCES `identificarProduto`.`cidade` (`idcidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`logradouro` (
  `idlogradouro` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `idtipoLogradouro` INT(11) NOT NULL,
  PRIMARY KEY (`idlogradouro`),
  INDEX `fk_logradouro_tipoLogradouro1_idx` (`idtipoLogradouro` ASC),
  CONSTRAINT `fk_logradouro_tipoLogradouro1`
    FOREIGN KEY (`idtipoLogradouro`)
    REFERENCES `identificarProduto`.`tipoLogradouro` (`idtipoLogradouro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`tipoLogradouro` (
  `idtipoLogradouro` INT(11) NOT NULLAUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idtipoLogradouro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`bairro` (
  `idbairro` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idbairro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`cidade` (
  `idcidade` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `siglaUF` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idcidade`),
  INDEX `fk_cidade_UF1_idx` (`siglaUF` ASC),
  CONSTRAINT `fk_cidade_UF1`
    FOREIGN KEY (`siglaUF`)
    REFERENCES `identificarProduto`.`UF` (`siglaUF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`UF` (
  `siglaUF` VARCHAR(2) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `idpaís` INT(11) NOT NULL,
  PRIMARY KEY (`siglaUF`),
  INDEX `fk_UF_país1_idx` (`idpaís` ASC),
  CONSTRAINT `fk_UF_país1`
    FOREIGN KEY (`idpaís`)
    REFERENCES `identificarProduto`.`país` (`idpaís`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`país` (
  `idpaís` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idpaís`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`vendedor` (
  `idvendedor` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `CPF` VARCHAR(11) NULL DEFAULT NULL,
  `numeroCasa` INT(11) NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `idendereço` INT(11) NOT NULL,
  PRIMARY KEY (`idvendedor`),
  INDEX `fk_vendedor_endereço1_idx` (`idendereço` ASC),
  CONSTRAINT `fk_vendedor_endereço1`
    FOREIGN KEY (`idendereço`)
    REFERENCES `identificarProduto`.`endereço` (`idendereço`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`emailVendedor` (
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `idvendedor` INT(11) NOT NULL,
  INDEX `fk_emailVendedor_vendedor1_idx` (`idvendedor` ASC),
  CONSTRAINT `fk_emailVendedor_vendedor1`
    FOREIGN KEY (`idvendedor`)
    REFERENCES `identificarProduto`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`foneVendedor` (
  `numero` VARCHAR(12) NULL DEFAULT NULL,
  `idvendedor` INT(11) NOT NULL,
  `idDDD` INT(11) NOT NULL,
  `idtipoFone` INT(11) NOT NULL,
  INDEX `fk_foneVendedor_vendedor1_idx` (`idvendedor` ASC),
  INDEX `fk_foneVendedor_DDD1_idx` (`idDDD` ASC),
  INDEX `fk_foneVendedor_tipoFone1_idx` (`idtipoFone` ASC),
  CONSTRAINT `fk_foneVendedor_vendedor1`
    FOREIGN KEY (`idvendedor`)
    REFERENCES `identificarProduto`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_foneVendedor_DDD1`
    FOREIGN KEY (`idDDD`)
    REFERENCES `identificarProduto`.`DDD` (`idDDD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_foneVendedor_tipoFone1`
    FOREIGN KEY (`idtipoFone`)
    REFERENCES `identificarProduto`.`tipoFone` (`idtipoFone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`DDD` (
  `idDDD` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idDDD`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`tipoFone` (
  `idtipoFone` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeTipo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idtipoFone`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`cliente` (
  `idcliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `CPF` VARCHAR(11) NULL DEFAULT NULL,
  `numeroCasa` INT(11) NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `idendereço` INT(11) NOT NULL,
  PRIMARY KEY (`idcliente`),
  INDEX `fk_cliente_endereço1_idx` (`idendereço` ASC),
  CONSTRAINT `fk_cliente_endereço1`
    FOREIGN KEY (`idendereço`)
    REFERENCES `identificarProduto`.`endereço` (`idendereço`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`clienteProduto` (
  `idcliente` INT(11) NOT NULL,
  `idProduto` INT(11) NOT NULL,
  INDEX `fk_clienteProduto_cliente1_idx` (`idcliente` ASC),
  INDEX `fk_clienteProduto_Produto1_idx` (`idProduto` ASC),
  CONSTRAINT `fk_clienteProduto_cliente1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `identificarProduto`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clienteProduto_Produto1`
    FOREIGN KEY (`idProduto`)
    REFERENCES `identificarProduto`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`emailCliente` (
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `idcliente` INT(11) NOT NULL,
  INDEX `fk_emailCliente_cliente1_idx` (`idcliente` ASC),
  CONSTRAINT `fk_emailCliente_cliente1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `identificarProduto`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`foneCliente` (
  `fone` VARCHAR(11) NULL DEFAULT NULL,
  `idcliente` INT(11) NOT NULL,
  `idtipoFone` INT(11) NOT NULL,
  `idDDD` INT(11) NOT NULL,
  INDEX `fk_foneCliente_cliente1_idx` (`idcliente` ASC),
  INDEX `fk_foneCliente_tipoFone1_idx` (`idtipoFone` ASC),
  INDEX `fk_foneCliente_DDD1_idx` (`idDDD` ASC),
  CONSTRAINT `fk_foneCliente_cliente1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `identificarProduto`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_foneCliente_tipoFone1`
    FOREIGN KEY (`idtipoFone`)
    REFERENCES `identificarProduto`.`tipoFone` (`idtipoFone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_foneCliente_DDD1`
    FOREIGN KEY (`idDDD`)
    REFERENCES `identificarProduto`.`DDD` (`idDDD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`notaFiscalVenda` (
  `idnotaFiscalVenda` INT(11) NOT NULL AUTO_INCREMENT,
  `dataEmissao` VARCHAR(45) NULL DEFAULT NULL,
  `valorNF` FLOAT(11) NULL DEFAULT NULL,
  `idcliente` INT(11) NOT NULL,
  `idvendedor` INT(11) NOT NULL,
  PRIMARY KEY (`idnotaFiscalVenda`),
  INDEX `fk_notaFiscalVenda_cliente1_idx` (`idcliente` ASC),
  INDEX `fk_notaFiscalVenda_vendedor1_idx` (`idvendedor` ASC),
  CONSTRAINT `fk_notaFiscalVenda_cliente1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `identificarProduto`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notaFiscalVenda_vendedor1`
    FOREIGN KEY (`idvendedor`)
    REFERENCES `identificarProduto`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`fatura` (
  `idfatura` INT(11) NOT NULL AUTO_INCREMENT,
  `dataVencimento` VARCHAR(45) NULL DEFAULT NULL,
  `valorfatura` FLOAT(11) NULL DEFAULT NULL,
  `valorPago` FLOAT(11) NULL DEFAULT NULL,
  `dataPagamento` VARCHAR(45) NULL DEFAULT NULL,
  `idnotaFiscalVenda` INT(11) NOT NULL,
  `idsituaçaoFatura` INT(11) NOT NULL,
  PRIMARY KEY (`idfatura`),
  INDEX `fk_fatura_notaFiscalVenda1_idx` (`idnotaFiscalVenda` ASC),
  INDEX `fk_fatura_situaçaoFatura1_idx` (`idsituaçaoFatura` ASC),
  CONSTRAINT `fk_fatura_notaFiscalVenda1`
    FOREIGN KEY (`idnotaFiscalVenda`)
    REFERENCES `identificarProduto`.`notaFiscalVenda` (`idnotaFiscalVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fatura_situaçaoFatura1`
    FOREIGN KEY (`idsituaçaoFatura`)
    REFERENCES `identificarProduto`.`situaçaoFatura` (`idsituaçaoFatura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`situaçaoFatura` (
  `idsituaçaoFatura` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idsituaçaoFatura`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `identificarProduto`.`fornecedor` (
  `idfornecedor` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `CNPJ` VARCHAR(20) NULL DEFAULT NULL,
  `numeroComercial` VARCHAR(5) NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `idendereço` INT(11) NOT NULL,
  PRIMARY KEY (`idfornecedor`),
  INDEX `fk_fornecedor_endereço1_idx` (`idendereço` ASC),
  CONSTRAINT `fk_fornecedor_endereço1`
    FOREIGN KEY (`idendereço`)
    REFERENCES `identificarProduto`.`endereço` (`idendereço`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
