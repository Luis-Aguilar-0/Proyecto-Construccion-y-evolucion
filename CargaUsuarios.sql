select * from usuario
--agregando los primeros registros a la base
insert into usuario(nombre,email,password,ajoloCoins,saldo,fechaNacimiento)
values('laac_0','armandoLuisCas@gmail.com','slt-',100,100.0,'2000-06-20'),
		('fox_0','francis@gmail.com','slt-',100,100.0,'1999-01-01'), 
		('kaede_0','bryan32s@gmail.com','gatos12',100,100.0,'1999-02-08')


--se agregan 20 tarjetas nuevas
--select * from tarjetacredito
declare @contador int = 1;
while @contador <= 20
begin 
	insert into tarjetacredito DEFAULT VALUES; --solo agrega el id de la tarjeta
SET @contador = @contador + 1
END


--
select *  from usuario
select * from juegos
select * from usuario_juego

--asiganacion de un juego a el primer usuario
insert into usuario_juego(idUsuario,idJuego)
values(1,1) --el primer 1 corresponde al id del usuario el segundo 1 corresponde al id del juego
			--cada usuario solo puede tener un solo juego de cada titulo

--muestra los juegos que tiene cada usuario
--nos servira mas adelante para obtener los juegos de cada usuario
select us.nombre as usuario,
		j.nombreJuego AS juego,
		j.idJuego
from usuario_juego uj join usuario us on uj.idUsuario = us.id 
					  join juegos j on j.idJuego = uj.idJuego

select * from juegos
