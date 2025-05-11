CREATE TABLE tarjetacredito (
	idTarjetaCredito int IDENTITY(1,1)not null 
	,numTarjeta BIGINT 
	,tipoTarjeta VARCHAR(50)  -- puede ser debito o credito
	,fExpiracion DATE  --fecha de expiracion
	,cSeguridad INT  --codigo se seguridad 
	CONSTRAINT PK_tarjetacredito PRIMARY KEY (idTarjetaCredito)
)


CREATE TABLE juegos (
	idJuego int identity(1,1) not null
	,nombreJuego VARCHAR(100) 
	,rMinimos VARCHAR(200) --Requisitos minimos del juego
	,rRecomendados VARCHAR(200) --requisitos recomendados del juego
	,precio float not null 
	,precioAjoloCoins int
	,desarrollador VARCHAR(100) 
	,fechaLanzamiento DATE 
	,portada varchar(255) --las imagenes, solo se guardara la direccion en donde se encuentran
	,imagenUno VARCHAR(255) 
	,imagenDos VARCHAR(255) 
	,imagenTres VARCHAR(255)
	,categoria int --es mejor manejarla con numeros y no Strings
	,descripcion VARCHAR(1000)
	CONSTRAINT PK_juegos PRIMARY KEY (idJuego)
)


--drop table usuario_juego
--drop table juegos
--drop table usuario
--drop table tarjetacredito


CREATE TABLE usuario (
	id INT identity(1,1) not null
	,nombre VARCHAR(100) not null
	,email VARCHAR(100) not null
	,password VARCHAR(100) not null
	,ajoloCoins INT 
	,fotoPerfil VARBINARY(MAX) 
	,idTarjetaCredito INT 
	,saldo float
	,fechaNacimiento Date not null
	CONSTRAINT PK_usuario PRIMARY KEY (id),
	--la siguiente linea relaciona las tablas usuario con tarjeta de credito
	CONSTRAINT PK_usuario_tarjetacredito FOREIGN KEY (idTarjetaCredito) REFERENCES tarjetacredito(idTarjetaCredito)
)

--tabal que relaciona las demas tablas
CREATE TABLE usuario_juego(
	idUsuario int not null
	,idJuego int not null
	--,fechaCompra DATE --aun no se si esto lo agregemos xD
	CONSTRAINT PK_usuario_juego PRIMARY KEY (idUsuario, idJuego), --evita duplicados de la misma compra (no puedes comprar el mismo juego por usuario)
	CONSTRAINT Fk_usuariojuego_usuario FOREIGN KEY (idUsuario) REFERENCES usuario(id),--solo se pueden aignar juegos a usuarios existentes
	CONSTRAINT FK_usuariojugo_juego FOREIGN KEY (idJuego) REFERENCES juegos(idJuego)--solo puedes asignar juegos existentes
)






select * from juegos
select * from tarjetacredito
select * from usuario
select * from usuario_juego

