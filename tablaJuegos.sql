CREATE TABLE `juegos` (
	`nombreJuego` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`rMinimos` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`rRecomendados` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`precio` INT(11) NULL DEFAULT NULL,
	`desarrollador` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`fexhaLazamiento` DATE NULL DEFAULT NULL,
	`rImagenUno` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`rImagenDos` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`rImagenTres` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_uca1400_ai_ci',
	`idJuego` INT(11) NULL DEFAULT NULL,
	`idBiblioteca` INT(11) NULL DEFAULT NULL
)
COLLATE='utf8mb4_uca1400_ai_ci'
ENGINE=InnoDB
;
