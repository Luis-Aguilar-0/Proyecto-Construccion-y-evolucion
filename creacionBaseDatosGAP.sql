CREATE TABLE `usuario` (
	`id` INT(11) NULL DEFAULT NULL,
	`nombre` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`email` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`pasword` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`ajoloCoins` INT(11) NULL DEFAULT NULL,
	`fotoPerfil` LONGBLOB NULL DEFAULT NULL,
	`idBiblioteca` INT(11) NULL DEFAULT NULL,
	`idTarjetaCredito` INT(11) NULL DEFAULT NULL,
	`saldo` INT(11) NULL DEFAULT NULL
)
COLLATE='utf8mb4_uca1400_ai_ci'
ENGINE=InnoDB
;
