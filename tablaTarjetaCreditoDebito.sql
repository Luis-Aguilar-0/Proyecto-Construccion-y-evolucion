CREATE TABLE `tarjetacredito` (
	`idTarjetaCredito` INT(11) NULL DEFAULT NULL,
	`numTarjeta` BIGINT(20) NULL DEFAULT NULL,
	`tipoTarjeta` VARCHAR(100) NULL DEFAULT NULL COMMENT 'puede ser debito o credito' COLLATE 'utf8mb4_uca1400_ai_ci',
	`fExpiracion` DATE NULL DEFAULT NULL,
	`cSeguridad` INT(11) NULL DEFAULT NULL
)
COLLATE='utf8mb4_uca1400_ai_ci'
ENGINE=InnoDB
;
