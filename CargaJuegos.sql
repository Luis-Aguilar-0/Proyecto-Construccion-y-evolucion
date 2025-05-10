--Carga de juegos a la talba juegos
Use gapbd;
go

--para agregar las imagenes solo se almacena la direccion de donde esta la imagen
--sigan la direccion siguiente
--'/imagenes/imagenesJuegos/nombre-de-la-imagen.extencio'
--los nombres de las imagenes tiene que tener el siguiente formato
--PortadaNombreDelJuego
--NombreDelJuegoUno
--NombreDelJuegofoDos
--NombreDelJuegoRes


GO
insert into juegos(nombreJuego,rMinimos,rRecomendados,precio,desarrollador,fechaLanzamiento,
				portada,imagenUno,imagenDos,imagenTres,categoria,descripcion)
values(
		'Enter the Gungeon'--nombre del juego
		,'SO: Windows 7 o posterior.Memoria: 2 GB de RAM.Almacenamiento: 2 GB de espacio en el disco duro.'--requisitos minimos
		,'SO: Windows 7 o posterior.Memoria: 2 GB de RAM.Almacenamiento: 2 GB de espacio en el disco duro.'--requisitos recomendados
		,178.99 --precio en pesos mexicanos
		,'Dodge Roll'--desarrollador
		,'2016-04-05'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Accion/PortadaEnterTheGungeon.jpg'--portada
		,'/imagenes/imagenesJuegos/EnterTheGungeonUno'--imagenes
		,'/imagenes/imagenesJuegos/EnterTheGungeonDos'
		,'/imagenes/imagenesJuegos/EnterTheGungeonTres'
		,0 --categor�a
		,'Enter the Gungeon es un juego de mazmorras y disparos que sigue los pasos de una banda de inadaptados que solo quieren disparar, saquear,esquivar y destrozar todo en su camino a la absoluci�n personal por llegar al tesoro final de la Armazmorra legendaria: el arma que puede matar el pasado.'
		), --descripcion
		(
		'Hades'--nombre del juego
		,'SO: Windows 7 SP1.Memoria: 4 GB de RAM.Almacenamiento: 15 GB.'--requisitos minimos
		,'SO: Windows 7 SP1.Memoria: 8 GB de RAM.Almacenamiento: 20 GB.'--requisitos recomendados
		,282.99 --precio en pesos mexicanos
		,'Supergiant Games'--desarrollador
		,'2018-12-06'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Accion/PortadaHades.jpg'--portada
		,'/imagenes/imagenesJuegos/HadesUno'--imagenes
		,'/imagenes/imagenesJuegos/HadesDos'
		,'/imagenes/imagenesJuegos/HadesTres'
		,0 --categor�a
		,'Hades es un juego de estilo roguelike de dioses y mazmorras que combina los mejores aspectos de los aclamados t�tulos anteriores de Supergiant, como la acci�n vertiginosa de Bastion, la rica atm�sfera y profundidad de Transistor y la narrativa enfocada en los personajes de Pyre. Como el Pr�ncipe inmortal del Inframundo, blandir�s los poderes y las armas m�ticas del Olimpo para liberarte de las garras del mism�simo dios de los muertos, mientras te fortaleces y revelas m�s partes de la historia con cada intento de escape.') --descripcion

		,(
		'Risk of Rain'--nombre del juego
		,'SO: Windows Vista / 7.Memoria:  1 GB de RAM.Almacenamiento: 130 MB de espacio disponible.'--requisitos minimos
		,'SO: Windows 10.Memoria:  4 GB de RAM.Almacenamiento: 4 GB de espacio disponible.'--requisitos recomendados
		,109.99 --precio en pesos mexicanos
		,'Hopoo Games'--desarrollador
		,'2013-11-08'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Accion/PortadaRiskOfRain.jpg'--portada
		,'/imagenes/imagenesJuegos/RiskOfRainUno'--imagenes
		,'/imagenes/imagenesJuegos/RiskOfRainDos'
		,'/imagenes/imagenesJuegos/RiskOfRainTres'
		,0 --categor�a
		,'Risk of Rain es un juego de plataformas de acci�n con elementos roguelike. Descubra una mir�ada de etapas elegidas al azar, desde el bosque desolado hasta la tundra congelada.') --descripcion

		,(
		'Slay the Spire'--nombre del juego
		,'SO: Windows XP, Vista, 7, 8/8.1, 10.Memoria: 2 GB de RAM.Almacenamiento: 1 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows XP, Vista, 7, 8/8.1, 10.Memoria: 4 GB de RAM.Almacenamiento: 1 GB de espacio disponible.'--requisitos recomendados
		,290.00 --precio en pesos mexicanos
		,'Megacrit'--desarrollador
		,'2019-01-23'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Accion/PortadaSlayTheSpire.jpg'--portada
		,'/imagenes/imagenesJuegos/SlayTheSpireUno'--imagenes
		,'/imagenes/imagenesJuegos/SlayTheSpireDos'
		,'/imagenes/imagenesJuegos/SlayTheSpireTres'
		,0 --categor�a
		,'Slay the Spire fusiona juegos de cartas y roguelites juntos: crea una baraja �nica, encuentra criaturas extra�as, descubre reliquias de inmenso poder y Slay the Spire') --descripcion

		,(
		'Spelunky 2'--nombre del juego
		,'SO: Windows 10 64-bit.Memoria: 4 GB de RAM.Almacenamiento: 600 MB de espacio disponible.'--requisitos minimos
		,'SO: Windows 10 64-bit.Memoria: 4 GB de RAM.Almacenamiento: 600 MB de espacio disponible.'--requisitos recomendados
		,185.99 --precio en pesos mexicanos
		,'BlitWorks.Mossmouth'--desarrollador
		,'2020-09-15'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Accion/PortadaSpelunky2.jpg'--portada
		,'/imagenes/imagenesJuegos/Spelunky2Uno'--imagenes
		,'/imagenes/imagenesJuegos/Spelunky2Dos'
		,'/imagenes/imagenesJuegos/Spelunky2Tres'
		,0 --categor�a
		,'Spelunky 2 es la secuela del juego de exploraci�n de cuevas/caza de tesoros Spelunky. Sigue a Ana Spelunky y sus amigas en una emocionante nueva aventura mientras viajan m�s profundo de lo que podr�an haber imaginado'); --descripcion

insert into juegos(nombreJuego,rMinimos,rRecomendados,precio,desarrollador,fechaLanzamiento,
				portada,imagenUno,imagenDos,imagenTres,categoria,descripcion)
values(
		'Factorio'--nombre del juego
		,'SO: Windows 11, 10.Memoria: 8 GB de RAM.Almacenamiento: 5 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 11, 10.Memoria: 16 GB de RAM.Almacenamiento: 10 GB de espacio disponible.'--requisitos recomendados
		,400.00 --precio en pesos mexicanos
		,'Wube Software'--desarrollador
		,'2020-08-14'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Estrategia/PortadaFactorio.jpg'--portada
		,'/imagenes/imagenesJuegos/FactorioUno'--imagenes
		,'/imagenes/imagenesJuegos/FactorioDos'
		,'/imagenes/imagenesJuegos/FactorioTres'
		,1 --categor�a
		,'Factorio es un juego sobre la construcci�n de f�bricas en un planeta alien�gena. Estar�s extrayendo recursos, investigando tecnolog�as, construyendo infraestructura, automatizando la producci�n y luchando contra enemigos alien�genas.'
		), --descripcion
		(
		'Fall Guys'--nombre del juego
		,'SO: Windows 10 de 64 bits.Memoria: 8 GB de RAM.Almacenamiento: 2 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 10 de 64 bits.Memoria: 8 GB de RAM.Almacenamiento: 2 GB de espacio disponible.'--requisitos recomendados
		,0.00 --precio en pesos mexicanos
		,'Mediatonic'--desarrollador
		,'2020-08-04'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Estrategia/PortadaFallGuys.jpg'--portada
		,'/imagenes/imagenesJuegos/FallGuysUno'--imagenes
		,'/imagenes/imagenesJuegos/FallGuysDos'
		,'/imagenes/imagenesJuegos/FallGuysTres'
		,1 --categor�a
		,'Fall Guys es un party royale gratuito, multiplataforma y multijugador masivo. Compite a tropezones en absurdas carreras de obst�culos con tus amigos. Esquiva todo en tu camino a la victoria en el pante�n de la torpeza. �Novato o profesional? �En solitario o en grupo? Fall Guys est� lleno de risas y diversi�n en constante evoluci�n. �Prefieres ser el agente del caos? Construye tu circuito de obst�culos y comp�rtelo 		con tus amigos y la comunidad.'
		), -- descripcion
		(
		'FTL: Faster Than Light'--nombre del juego
		,'SO: Windows 7 o posterior.Memoria: 1 GB.Almacenamiento: 200 MB.'--requisitos minimos
		,'SO: Windows 7 o posterior.Memoria: 1 GB.Almacenamiento: 200 MB.'--requisitos recomendados
		,129.00 --precio en pesos mexicanos
		,'Subset Games'--desarrollador
		,'2012-09-14'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Estrategia/PortadaFTL.jpg'--portada
		,'/imagenes/imagenesJuegos/FTLUno'--imagenes
		,'/imagenes/imagenesJuegos/FTLDos'
		,'/imagenes/imagenesJuegos/FTLTres'
		,1 --categor�a
		,'Esta especie de "roguelike de simulaci�n de naves espaciales" te permite llevar tu nave y tu tripulaci�n en una aventura a trav�s de una galaxia generada al azar llena de gloria y amarga derrota. Da �rdenes a tu tripulaci�n, gestiona la distribuci�n de energ�a del barco y elige objetivos de armas en el fragor de la batalla.'
		), --descripci�n
		(
		'Slime Rancher'--nombre del juego
		,'SO: Windows 7 o posterior.Memoria: 4 GB de RAM.Almacenamiento: 1 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 7 o posterior.Memoria: 4 GB de RAM.Almacenamiento: 1 GB de espacio disponible.'--requisitos recomendados
		,156.99 --precio en pesos mexicanos
		,'Monomi Park'--desarrollador
		,'2016-01-14'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Estrategia/PortadaSlimeRancher.jpg'--portada
		,'/imagenes/imagenesJuegos/SlimeRancherUno'--imagenes
		,'/imagenes/imagenesJuegos/SlimeRancherDos'
		,'/imagenes/imagenesJuegos/SlimeRancherTres'
		,1 --categor�a
		,'Slime Rancher es una encantadora experiencia sandbox en primera persona. Juega como Beatrix LeBeau, una intr�pida y joven ranchera que se prepara para una vida a mil a�os luz de la Tierra en la "Lejana, Lejana Pradera" (Far, Far Range). Cada d�a presentar� nuevos desaf�os y riesgosas oportunidades mientras intentas acumular una gran fortuna en el negocio de los ranchos de slimes. Colecciona slimes coloridos, siembra cultivos, cosecha recursos y explora la naturaleza ind�mita a trav�s del dominio de tu vacpack multiuso.'
		), --descripci�n
		(
		'Stardew Valley'--nombre del juego
		,'SO: Windows Vista o greater.Memoria: 2 GB de RAM.Almacenamiento: 500 MB de espacio disponible.'--requisitos minimos
		,'SO: Windows Vista o greater.Memoria: 2 GB de RAM.Almacenamiento: 500 MB de espacio disponible.'--requisitos recomendados
		,149.99 --precio en pesos mexicanos
		,'ConcernedApe.Sickhead Games'--desarrollador
		,'2016-02-26'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Estrategia/PortadaStardewValley.jpg'--portada
		,'/imagenes/imagenesJuegos/StardewValleyUno'--imagenes
		,'/imagenes/imagenesJuegos/StardewValleyDos'
		,'/imagenes/imagenesJuegos/StardewValleyTres'
		,1 --categor�a
		,'Acabas de heredar la vieja parcela agr�cola de tu abuelo de Stardew Valley. Decides partir hacia una nueva vida con unas herramientas usadas y algunas monedas. �Te ves capaz de vivir de la tierra y convertir estos campos descuidados en un hogar pr�spero?'
		); --descripci�n

insert into juegos(nombreJuego,rMinimos,rRecomendados,precio,desarrollador,fechaLanzamiento,
				portada,imagenUno,imagenDos,imagenTres,categoria,descripcion)
values(
		'ABZU'--nombre del juego
		,'SO: Windows 7, 64-bit.Memoria: 4 GB RAM.Almacenamiento: 6 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 7, 64-bit.Memoria: 8 GB RAM.Almacenamiento: 6 GB de espacio disponible.'--requisitos recomendados
		,156.99 --precio en pesos mexicanos
		,'Giant Squid'--desarrollador
		,'2016-08-02'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Narrativa/PortadaAbzu.jpg'--portada
		,'/imagenes/imagenesJuegos/AbzuUno'--imagenes
		,'/imagenes/imagenesJuegos/AbzuDos'
		,'/imagenes/imagenesJuegos/AbzuTres'
		,2 --categor�a
		,'ABZU es el proyecto de desarrollo debut del desarrollador Giant Squid y el Director Creativo Matt Nava, quien fue uno de los principales contribuyentes a los hermosos y aclamados t�tulos Flower and Journey.') --descripci�n

		,(
		'Gris'--nombre del juego
		,'SO: Windows 7.Memoria: 4 GB de RAM.Almacenamiento: 4 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 10.Memoria: 8 GB de RAM.Almacenamiento: 4 GB de espacio disponible.'--requisitos recomendados
		,178.99 --precio en pesos mexicanos
		,'Nomada Studio'--desarrollador
		,'2018-12-13'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Narrativa/PortadaGris.jpg'--portada
		,'/imagenes/imagenesJuegos/GrisUno'--imagenes
		,'/imagenes/imagenesJuegos/GrisDos'
		,'/imagenes/imagenesJuegos/GrisTres'
		,2 --categor�a
		,'Gris es una muchacha llena de esperanzas y perdida en su propio mundo, enfrentada a una experiencia dolorosa de su vida. En el sereno y evocador Gris interactivo. Los jugadores explorar�n un mundo meticuloso dise�ado que cobra vida con arte delicado, animaci�n detallada y una elegante partitura original.') --descripci�n

		,(
		'Journey'--nombre del juego
		,'SO: Windows 7.Memoria: 4 GB de RAM y 1 GB de VRAM.Almacenamiento: 4 GB.'--requisitos minimos
		,'SO: Windows 10.Memoria: 4 GB de RAM y 2 GB de VRAM.Almacenamiento: 4 GB.'--requisitos recomendados
		,159.99 --precio en pesos mexicanos
		,'Thatgamecompany (TGC).Tricky Pixels'--desarrollador
		,'2012-03-13'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Narrativa/PortadaJourney.jpg'--portada
		,'/imagenes/imagenesJuegos/JourneyUno'--imagenes
		,'/imagenes/imagenesJuegos/JourneyDos'
		,'/imagenes/imagenesJuegos/JourneyTres'
		,2 --categor�a
		,'Explora el antiguo y misterioso mundo de Journey mientras vuelas sobre ruinas y planeas a lo largo del desierto para descubrir sus secretos. Juega solo o en compa��a de un viajero y exploren juntos este inmenso mundo. Gracias a sus incre�bles gr�ficos y su banda sonora nominada al Grammy, Journey te ofrece una experiencia impresionante como ninguna otra.') --descripci�n

		,(
		'Night in the Woods'--nombre del juego
		,'SO: Windows 7.Memoria: 8 GB de RAM.Almacenamiento: 8 GB.'--requisitos minimos
		,'SO: Windows 10.Memoria: 16 GB de RAM.Almacenamiento: 8 GB.'--requisitos recomendados
		,161.99 --precio en pesos mexicanos
		,'Finji Games.Infinite Fall'--desarrollador
		,'2017-01-10'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Narrativa/PortadaNightInTheWoods.jpg'--portada
		,'/imagenes/imagenesJuegos/NightInTheWoodsUno'--imagenes
		,'/imagenes/imagenesJuegos/NightInTheWoodsDos'
		,'/imagenes/imagenesJuegos/NightInTheWoodsTres'
		,2 --categor�a
		,'Night in the Woods es un juego de aventura sobre un personaje que ha abandonado la universidad y vuelve a casa, donde se encuentra con los 		amigos y el pueblo que hab�a dejado atr�s. Rompe cosas, toca el bajo, rel�jate y pasa el rato, visita distintos lugares y descubre cosas que 		no deber�as saber. Vuelve a Possum Springs, tu hogar.') --descripci�n

		,(
		'Outer Wilds'--nombre del juego
		,'SO: Windows 10.Memoria: 6 GB de RAM.Almacenamiento: 8 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 10.Memoria: 8 GB de RAM.Almacenamiento: 8 GB de espacio disponible.'--requisitos recomendados
		,269.99 --precio en pesos mexicanos
		,'Mobius Digital.Annapurna Interactive'--desarrollador
		,'2020-06-10'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Narrativa/PortadaOuterWilds.jpg'--portada
		,'/imagenes/imagenesJuegos/OuterWildsUno'--imagenes
		,'/imagenes/imagenesJuegos/OuterWildsDos'
		,'/imagenes/imagenesJuegos/OuterWildsTres'
		,1 --categor�a
		,'Eres la nueva incorporaci�n de Outer Wilds Ventures, un programa espacial incipiente que busca respuestas en un sistema solar extra�o y en constante evoluci�n.
		Los misterios del sistema solar...
		�Qu� acecha en el coraz�n del peligroso planeta Dark Bramble? �Qui�n o qu� construy� las ruinas alien�genas en la Luna? �Es posible detener el interminable bucle de tiempo? Todas estas respuestas te aguardan en los rincones m�s profundos y riesgosos del espacio.
		El tiempo todo lo cambia...
		Los planetas de Outer Wilds se encuentran plagados de ubicaciones ocultas que cambian con el paso del tiempo. Visita una ciudad subterr�nea antes de que se la trague la arena o explora la superficie de un planeta y observa c�mo se cae a pedazos bajo tus propias narices. Unos ambientes peligrosos y las cat�strofes naturales guardan cada uno de estos secretos.'); -- descripci�n

insert into juegos(nombreJuego,rMinimos,rRecomendados,precio,desarrollador,fechaLanzamiento,
				portada,imagenUno,imagenDos,imagenTres,categoria,descripcion)
values(
		'Cave Story'--nombre del juego
		,'SO: Windows XP.Memoria: 128 MB de RAM.Almacenamiento: 200 MB.'--requisitos minimos
		,'SO: Windows 7.Memoria: 512 MB de RAM.Almacenamiento: 200 MB.'--requisitos recomendados
		,120.99 --precio en pesos mexicanos
		,'Nicalis.Inc./Studio Pixel'--desarrollador
		,'2007-12-31'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Plataforma/PortadaCaveStory.jpg'--portada
		,'/imagenes/imagenesJuegos/CaveStoryUno'--imagenes
		,'/imagenes/imagenesJuegos/CaveStoryDos'
		,'/imagenes/imagenesJuegos/CaveStoryTres'
		,3 --categor�a
		,'Podr�a decirse que es el juego indie m�s conocido de todos los tiempos. Cave Story+ ofrece una historia original con personalidad propia, misterio y diversi�n a toda velocidad. �Corre, salta, dispara, vuela y explora en esta gigantesca aventura con el sabor de los cl�sicos de 8 y 16 bits!') --descripci�n

		,(
		'Celeste'--nombre del juego
		,'SO: Windows 7 o m�s reciente.Memoria: 2 GB de RAM.Almacenamiento: 1300 MB de espacio disponible.'--requisitos minimos
		,'SO: Por confirmar.Memoria: Por confirmar.Almacenamiento: Por confirmar.'--requisitos recomendados
		,156.99 --precio en pesos mexicanos
		,'Maddy Makes Games'--desarrollador
		,'2018-01-25'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Plataforma/PortadaCeleste.jpg'--portada
		,'/imagenes/imagenesJuegos/CelesteUno'--imagenes
		,'/imagenes/imagenesJuegos/CelesteDos'
		,'/imagenes/imagenesJuegos/CelesteTres'
		,3 --categor�a
		,'Ayuda a Madeline a sobrevivir contra sus demonios internos en su traves�a rumbo a la cima de la monta�a Celeste, en este juego de plataformas s�per intenso de los creadores de TowerFall. Enfr�ntate a cientos de desaf�os dise�ados a mano, descubre secretos enigm�ticos y revela los misterios de la monta�a.') --descripci�n

		,(
		'Dead Cells'--nombre del juego
		,'SO: Windows 7 o posterior.Memoria: 2 GB de RAM.Almacenamiento: 800 MB de espacio disponible.'--requisitos minimos
		,'SO: Windows 7 o posterior.Memoria: 4 GB de RAM.Almacenamiento: 800 MB de espacio disponible.'--requisitos recomendados
		,201.99 --precio en pesos mexicanos
		,'Motion Twin'--desarrollador
		,'2018-08-07'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Plataforma/PortadaDeadCells.jpg'--portada
		,'/imagenes/imagenesJuegos/DeadCellsUno'--imagenes
		,'/imagenes/imagenesJuegos/DeadCellsDos'
		,'/imagenes/imagenesJuegos/DeadCellsTres'
		,3 --categor�a
		,'Dead Cells es un roguelite de acci�n y plataformas inspirado en los metroidvania. Explorar�s un castillo en constante cambio y expansi�n, si es que logras abrirte paso entre los guardianes en combates 2D de estilo Dark Souls. Sin puntos de control. Mata, muere, aprende y repite. No hay puntos de control. Esto se trata de matar, morir, aprender y repetir.
		Dead Cells te pone al mando de un experimento alqu�mico fallido que intenta averiguar qu� est� sucediendo en una isla extensa, cambiante y aparentemente maldita. Aunque seas inmortal, estar�s lisiado y deber�s poseer otros cuerpos para moverte, explorar� y luchar.') --			descripci�n

		,(
		'Fez'--nombre del juego
		,'SO: Windows XP SP3 (para la Versi�n 1.11, accesible a trav�s de la pesta�a "Betas").Memoria: 2 GB de RAM.Almacenamiento: 500 MB de espacio en el disco duro.'--requisitos minimos
		,'SO: Windows 7 (para la versi�n 1.12 o posterior).Memoria: 4 GB de RAM.Almacenamiento: 500 MB de espacio en el disco duro.'--requisitos recomendados
		,111.99 --precio en pesos mexicanos
		,'Polytron Corporation.Inc'--desarrollador
		,'2012-04-13'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Plataforma/PortadaFez.jpg'--portada
		,'/imagenes/imagenesJuegos/FezUno'--imagenes
		,'/imagenes/imagenesJuegos/FezDos'
		,'/imagenes/imagenesJuegos/FezTres'
		,3 --categor�a
		,'Gomez es una criatura 2D que vive en un mundo 2D. �O no? Cuando descubre la existencia de una misteriosa tercera dimensi�n, Gomez comienza un viaje que lo llevar� al final del tiempo y el espacio. Usa tu habilidad para manejar estructuras 3D desde 4 perspectivas 2D cl�sicas distintas.') --descripci�n

		,(
		'Hollow Knight'--nombre del juego
		,'SO: Windows 7 (64bit).Memoria: 4 GB de RAM.Almacenamiento: 9 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 10 (64bit).Memoria: 8 GB de RAM.Almacenamiento: 9 GB de espacio disponible.'--requisitos recomendados
		,178.99 --precio en pesos mexicanos
		,'Team Cherry'--desarrollador
		,'2017-02-24'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Plataforma/PortadaHollowKnight.jpg'--portada
		,'/imagenes/imagenesJuegos/HollowKnightUno'--imagenes
		,'/imagenes/imagenesJuegos/HollowKnightDos'
		,'/imagenes/imagenesJuegos/HollowKnightTres'
		,3 --categor�a
		,'Bajo la deteriorada ciudad de Petr�polis yace un antiguo reino en ruinas. A muchos les atrae la vida bajo la superficie y van en busca de riquezas, gloria o respuestas a viejos enigmas.
		Hollow Knight es una aventura de acci�n cl�sica en 2D ambientada en un vasto mundo interconectado. Explora cavernas tortuosas, ciudades antiguas y p�ramos mortales. Combate contra criaturas corrompidas, haz amistad con extra�os insectos y resuelve los antiguos misterios que yacen en el coraz�n de reino.') --descripci�n

		,(	
		'Ori And The Blind'--nombre del juego
		,'SO: Windows 7.Memoria: 4 GB de RAM.Almacenamiento: 8 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 7.Memoria: 4 GB de RAM.Almacenamiento: 8 GB de espacio disponible.'--requisitos recomendados
		,399.99 --precio en pesos mexicanos
		,'Moon Studios GmbH'--desarrollador
		,'2015-03-11'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Plataforma/PortadaOriAndTheBlind.jpg'--portada
		,'/imagenes/imagenesJuegos/OriAndTheBlindUno'--imagenes
		,'/imagenes/imagenesJuegos/OriAndTheBlindDos'
		,'/imagenes/imagenesJuegos/OriAndTheBlindTres'
		,3 --categor�a
		,'El bosque de Nibel est� muriendo. Despu�s de que una fuerte tormenta pusiera en marcha una serie de devastadores acontecimientos, un inesperado h�roe deber� partir en busca del valor y enfrentarse a su oscuro archienemigo; solo as� salvar� su hogar. Ori and the Blind Forest narra la historia de un joven hu�rfano destinado a convertirse en leyenda a trav�s de un juego de acci�n y plataformas preciosista creado por Moon Studios para PC. Gr�ficos e ilustraciones pintados a mano, personajes animados al detalle y una banda sonora totalmente orquestada dan vida a Ori and the Blind Forest, que explora una conmovedora historia sobre el amor y el sacrificio, y la esperanza que reside en todos nosotros.') --descripci�n

		,(
		'Shovel Knight'--nombre del juego
		,'SO: Windows 7.Memoria: 2 GB de RAM.Almacenamiento: 250 MB de espacio disponible.'--requisitos minimos
		,'SO: Windows 10.Memoria: 4 GB de RAM.Almacenamiento: 250 MB de espacio disponible.'--requisitos recomendados
		,149.99 --precio en pesos mexicanos
		,'Yacht Club Games'--desarrollador
		,'2014-01-26'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Plataforma/PortadaShovelKnight.jpg'--portada
		,'/imagenes/imagenesJuegos/ShovelKnightUno'--imagenes
		,'/imagenes/imagenesJuegos/ShovelKnightDos'
		,'/imagenes/imagenesJuegos/ShovelKnightTres'
		,3 --categor�a
		,'Shovel Knight es un fant�stico juego de aventura y acci�n cl�sica con una jugabilidad fuera de serie, personajes memorables y est�tica retro en 8 bits. �Una rompedora mezcla de novedad y clasicismo! Encarna al ""Caballero de la Pala"" que da nombre al juego. Peque�o, pero con una grandiosa y doble misi�n: derrotar a la malvada Hechicera y recuperar a su amada. Esgrime una afilada Pala: un arma multiusos cuya t�cnica se ha perdido en el cavar de los tiempos. Siempre honesto y servicial, Shovel Knight es un firme defensor del C�digo de la Paler�a: �Troncha sin piedad y cava sin parar!') --descripci�n

		,(
		'Super Meat Boy'--nombre del juego
		,'SO: Microsoft� Windows� XP/Vista/7/8/10.Memoria: 1 GB de RAM.Almacenamiento: 300 MB de espacio libre.'--requisitos minimos
		,'SO: Microsoft� Windows� 7 o 10.Memoria: 2 GB de RAM.Almacenamiento: 300 MB de espacio libre.'--requisitos recomendados
		,178.99 --precio en pesos mexicanos
		,'BlitWorks.Team Meat'--desarrollador
		,'2010-10-20'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Plataforma/PortadaSuperMeatBoy.jpg'--portada
		,'/imagenes/imagenesJuegos/SuperMeatBoyUno'--imagenes
		,'/imagenes/imagenesJuegos/SuperMeatBoyDos'
		,'/imagenes/imagenesJuegos/SuperMeatBoyTres'
		,3 --categor�a
		,'Super Meat Boy es un juego de plataforma dif�cil en el que se juega como un chico sin piel que necesita salvar a su novia hecha de vendajes de un feto maligno dentro un tarro que usa un sombrero de copa y un mon�culo.') --descripci�n

insert into juegos(nombreJuego,rMinimos,rRecomendados,precio,desarrollador,fechaLanzamiento,
				portada,imagenUno,imagenDos,imagenTres,categoria,descripcion)
values(
		'Braid'--nombre del juego
		,'SO: Microsoft� Windows� XP / Vista / 7.Memoria: 768 MB o m�s.Almacenamiento: 200 MB o m�s.'--requisitos minimos
		,'SO: Microsoft� Windows� 10.Memoria: 768 MB o m�s.Almacenamiento: 200 MB o m�s.'--requisitos recomendados
		,149.99 --precio en pesos mexicanos
		,'Number None Inc.'--desarrollador
		,'2008-08-06'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Puzles/PortadaBraid.jpg'--portada
		,'/imagenes/imagenesJuegos/BraidUno'--imagenes
		,'/imagenes/imagenesJuegos/BraidDos'
		,'/imagenes/imagenesJuegos/BraidTres'
		,4 --categor�a
		,'Braid es un juego de rompecabezas con toques plataformeros, presentado con un estilo pict�rico, donde puedes manipular el flujo del tiempo de unas maneras inusuales y extra�as. Desde una casa en la ciudad, comenzar�s una aventura hacia una serie de mundos y resolver�s rompecabezas para rescatar una princesa raptada. En cada mundo, tendr�s un poder diferente que afecta a la manera en la que el tiempo se comporta, y es precisamente la extra�eza del tiempo la que crea los rompecabezas. Los distintos comportamientos del tiempo incluyen: la posibilidad de rebobinar hacia atr�s, objetos inmunes al rebobinado, tiempo que est� unido al espacio, realidades paralelas, dilataci�n del tiempo, y quiz� m�s.') --descripci�n

		,(
		'Inside'--nombre del juego
		,'SO: Windows 7/8/10 (64 bits).Memoria: 4 GB de RAM.Almacenamiento: 3 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 8/10 (64 bits).Memoria: 8 GB de RAM.Almacenamiento: 3 GB de espacio disponible.'--requisitos recomendados
		,227.99 --precio en pesos mexicanos
		,'Playdead'--desarrollador
		,'2016-06-29'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Puzles/PortadaInside.jpg'--portada
		,'/imagenes/imagenesJuegos/InsideUno'--imagenes
		,'/imagenes/imagenesJuegos/InsideDos'
		,'/imagenes/imagenesJuegos/InsideTres'
		,4 --categor�a
		,'Descubre INSIDE, el indie de aventuras de Playdead, un juego de plataformas siniestro con historia que combina acci�n intensa con puzles desafiantes. Fue alabado por la cr�tica por su siniestro estilo art�stico, su banda sonora ambiental y su estremecedor ambiente.') --			descripci�n

		,(
		'Limbo'--nombre del juego
		,'SO: Windows XP, Vista, 7, 8, 10.Memoria: 512 MB de RAM.Almacenamiento: 150 MB.'--requisitos minimos
		,'SO: Windows XP, Vista, 7, 8, 10.Memoria: 512 MB de RAM.Almacenamiento: 150 MB.'--requisitos recomendados
		,123.99 --precio en pesos mexicanos
		,'Playdead.Double Eleven Studios'--desarrollador
		,'2010-07-21'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Puzles/PortadaLimbo.jpg'--portada
		,'/imagenes/imagenesJuegos/LimboUno'--imagenes
		,'/imagenes/imagenesJuegos/LimboDos'
		,'/imagenes/imagenesJuegos/LimboTres'
		,4 --categor�a
		,'Limbo es un laureado juego indie de aventuras que recibi� elogios por su atractiva funci�n de puzles y sus inmersivos gr�ficos y m�sica. Sus sombr�os y neblinosos entornos y su espeluznante historia te acompa�ar�n all� a donde vayas.') --descripci�n

		,(
		'The Witness'--nombre del juego
		,'SO: Windows 7.Memoria: 4 GB de RAM.Almacenamiento: 5 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 7.Memoria: 8 GB de RAM.Almacenamiento: 5 GB de espacio disponible.'--requisitos recomendados
		,336.99 --precio en pesos mexicanos
		,'Thekla Inc.'--desarrollador
		,'2016-01-26'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Puzles/PortadaTheWitness.jpg'--portada
		,'/imagenes/imagenesJuegos/TheWitnessUno'--imagenes
		,'/imagenes/imagenesJuegos/TheWitnessDos'
		,'/imagenes/imagenesJuegos/TheWitnessTres'
		,4 --categor�a
		,'Despiertas a solas, en una extra�a isla repleta de rompecabezas. Estos rompecabezas te desafiar�n y sorprender�n. No recuerdas qui�n eres ni c�mo llegaste aqu�, pero puedes hacer una cosa: explorar la isla con la esperanza de descubrir pistas, recuperar la memoria y encontrar el camino de vuelta a casa. The Witness te respeta porque eres un jugador inteligente y considera que tu tiempo es oro. Hay m�s de 500 rompecabezas, sin pistas, y cada uno de ellos aporta algo nuevo al conjunto. Es decir, es un juego lleno de ideas.') --descripci�n

		,(
		'Unpacking'--nombre del juego
		,'SO: Windows 7 SP1+.Memoria: 2 GB de RAM.Almacenamiento: 1 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 7 SP1+.Memoria: 4 GB de RAM.Almacenamiento: 1 GB de espacio disponible.'--requisitos recomendados
		,399.00 --precio en pesos mexicanos
		,'Witch Beam'--desarrollador
		,'2021-11-01'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Puzles/PortadaUnpacking.jpg'--portada
		,'/imagenes/imagenesJuegos/UnpackingUno'--imagenes
		,'/imagenes/imagenesJuegos/UnpackingDos'
		,'/imagenes/imagenesJuegos/UnpackingTres'
		,4 --categor�a
		,'Unpacking es un juego relajante acerca del sentimiento familiar de sacar pertenencias de cajas para colocarlas en un nuevo hogar. Mitad juego de bloques, mitad juego de decoraci�n, podr�s crear habitaciones agradables mientras descubres pistas de la vida que est�s desempacando. A lo largo de ocho mudanzas, tendr�s la oportunidad de experimentar una sensaci�n de intimidad con un personaje que no ves y con una historia que no te cuentan.') --descripci�n

		,(
		'What Remains of Edith Finch'--nombre del juego
		,'SO: Windows Vista SP2 de 64 bits o posterior.Memoria: 2 GB de RAM.Almacenamiento: 5 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 7.Memoria: 4 GB de RAM.Almacenamiento: 5 GB de espacio disponible.'--requisitos recomendados
		,199.99 --precio en pesos mexicanos
		,'SIE San Diego Studio.Giant Sparrow'--desarrollador
		,'2017-04-25'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Puzles/PortadaWhatRemains.jpg'--portada
		,'/imagenes/imagenesJuegos/WhatRemainsUno'--imagenes
		,'/imagenes/imagenesJuegos/WhatRemainsDos'
		,'/imagenes/imagenesJuegos/WhatRemainsTres'
		,4 --categor�a
		,'What Remains of Edith Finch es una colecci�n de historias sobre una familia en el estado de Washington. En el papel de Edith, explorar�s la casa de los Finch en busca de historias mientras explora su pasado familiar e intenta descubrir por qu� es la �ltima Finch viva.');--descripcion

		
insert into juegos(nombreJuego,rMinimos,rRecomendados,precio,desarrollador,fechaLanzamiento,
				portada,imagenUno,imagenDos,imagenTres,categoria,descripcion)
values(
		'Amnesia: The Dark Descent'--nombre del juego
		,'SO: Windows XP.Memoria: 2 GB.Almacenamiento: 3 GB.'--requisitos minimos
		,'SO: Windows 7.Memoria: 2 GB.Almacenamiento: 3 GB.'--requisitos recomendados
		,156.99 --precio en pesos mexicanos
		,'Frictional Games'--desarrollador
		,'2010-09-08'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Terror/PortadaAmnesia.jpg'--portada
		,'/imagenes/imagenesJuegos/AmnesiaUno'--imagenes
		,'/imagenes/imagenesJuegos/AmnesiaDos'
		,'/imagenes/imagenesJuegos/AmnesiaTres'
		,5 --categor�a
		,'Amnesia: The Dark Descent, un horror de supervivencia en primera persona. Un juego sobre inmersi�n, descubrimiento y vivir una pesadilla, una experiencia que te enfriar� hasta la m�dula.') --descripci�n

		,(
		'Little Nightmares 2'--nombre del juego
		,'SO: Windows 10.Memoria: 4 GB de RAM.Almacenamiento: 5 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 10.Memoria: 4 GB de RAM.Almacenamiento: 16 GB de espacio disponible.'--requisitos recomendados
		,469.00 --precio en pesos mexicanos
		,'Tarsier Studios'--desarrollador
		,'2021-02-11'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Terror/PortadaLittleNightmares2.jpg'--portada
		,'/imagenes/imagenesJuegos/LittleNightmares2Uno'--imagenes
		,'/imagenes/imagenesJuegos/LittleNightmares2Dos'
		,'/imagenes/imagenesJuegos/LittleNightmares2Tres'
		,5 --categor�a
		,'Little Nightmares II sigue la historia de Mono, un ni�o atrapado en un mundo distorsionado por la transmisi�n de un zumbido de una lejana Torre de Se�ales.') --descripci�n

		,(
		'Outlast'--nombre del juego
		,'SO: Windows XP/Vista/7/8 de 64 bits.Memoria: 2 GB de RAM.Almacenamiento: 5 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows Vista/7/8 de 64 bits.Memoria: 3 GB de RAM.Almacenamiento: 5 GB de espacio disponible.'--requisitos recomendados
		,161.99 --precio en pesos mexicanos
		,'Red Barrels'--desarrollador
		,'2013-09-04'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Terror/PortadaOutlast.jpg'--portada
		,'/imagenes/imagenesJuegos/OutlastUno'--imagenes
		,'/imagenes/imagenesJuegos/OutlastDos'
		,'/imagenes/imagenesJuegos/OutlastTres'
		,5 --categor�a
		,'El infierno es un experimento al que no sobrevivir�s en Outlast, un juego de terror y supervivencia en primera persona desarrollado por Red Barrels. Como el periodista de investigaci�n Miles Upshur, explora el manicomio de Mount Massive y sobrevive el mayor tiempo posible para descubrir su terrible secreto... si te animas') --descripci�n

		,(
		'Phasmophobia'--nombre del juego
		,'SO: Windows 10 64Bit.Memoria: 8 GB de RAM.Almacenamiento: 21 GB de espacio disponible.'--requisitos minimos
		,'SO: Windows 10 64Bit.Memoria: 8 GB de RAM.Almacenamiento: 21 GB de espacio disponible.'--requisitos recomendados
		,227.99 --precio en pesos mexicanos
		,'Kinetic Games'--desarrollador
		,'2020-09-17'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/Terror/PortadaPhasmophobia.jpg'--portada
		,'/imagenes/imagenesJuegos/PhasmophobiaUno'--imagenes
		,'/imagenes/imagenesJuegos/PhasmophobiaDos'
		,'/imagenes/imagenesJuegos/PhasmophobiaTres'
		,5 --categor�a
		,'Phasmophobia es un horror psicol�gico cooperativo en l�nea de 4 jugadores donde usted y los miembros de su equipo de investigadores paranormales ingresar�n a lugares embrujados llenos de actividad paranormal y reunir�n tanta evidencia de lo paranormal como puedan.'); --descripci�n

insert into juegos(nombreJuego,rMinimos,rRecomendados,precio,desarrollador,fechaLanzamiento,
				portada,imagenUno,imagenDos,imagenTres,categoria,descripcion)
values(
		'Cyberpunk 2077'
		,'SO: 64-bit Windows 10.Memoria: 12 GB de RAM.Almacenamiento: 70 GB de espacio disponible.'
		,'SO: 64-bit Windows 10.Memoria: 16 GB de RAM.Almacenamiento: 70 GB de espacio disponible.'
		,1299.00
		,'CD PROJEKT RED'
		,'2020-12-09'
		,'/imagenes/imagesJuegos/PortadaCyberpunk2077'
		,'/imagenes/imagenesJuegos/Cyberpunk2077Uno'
		,'/imagenes/imagenesJuegos/Cyberpunk2077Dos'
		,'/imagenes/imagenesJuegos/Cyberpunk2077Tres'
		,1
		,'Cyberpunk 2077 es un RPG de aventura y acci�n de mundo abierto ambientado en el futuro sombr�o de Night City, una peligrosa megal�polis obsesionada con el poder, el glamur y las incesantes modificaciones corporales.')
		
		,(
		'ELDEN RING'
		,'SO: Windows 10.Memoria: 12 GB de RAM.Almacenamiento: 60 GB de espacio disponible.'
		,'SO: Windows 10/11.Memoria: 16 GB de RAM.Almacenamiento: 60 GB de espacio disponible.'
		,819.00
		,'FromSoftware, Inc.'
		,'2022-02-24'
		,'/imagenes/imagesJuegos/PortadaEldenRing'
		,'/imagenes/imagenesJuegos/EldenRingUno'
		,'/imagenes/imagenesJuegos/EldenRingDos'
		,'/imagenes/imagenesJuegos/EldenRingTres'
		,1
		,'EL NUEVO JUEGO DE ROL Y ACCI�N DE AMBIENTACI�N FANT�STICA. �lzate, Sinluz, y que la gracia te gu�e para abrazar el poder del C�rculo de Elden y encumbrarte como se�or del C�rculo en las Tierras�Intermedias.')

		,(
		'Grand Theft Auto V'--nombre del juego
		,'SO: Windows 10 (�ltima actualizaci�n).Memoria: 8 GB de RAM.Almacenamiento: SSD con 105 GB de espacio requerido.'--requisitos minimos
		,'SO: Windows 11.Memoria: 16 GB de RAM con configuraci�n de doble canal.Almacenamiento: Unidad de 105 GB, compatible con DirectStorage.'--requisitos recomendados
		,599 --precio en pesos mexicanos
		,'Rockstar North.Rockstar Games'--desarrollador
		,'2013-09-17'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaGrandTheft.jpg'--portada
		,'/imagenes/imagenesJuegos/GrandTheftUno'--imagenes
		,'/imagenes/imagenesJuegos/GrandTheftDos'
		,'/imagenes/imagenesJuegos/GrandTheftTres'
		,0 --categor�a
		,'Un joven estafador callejero, un ladr�n de bancos retirado y un psic�pata aterrador se ven enredados con algunos de los elementos m�s aterradores y desquiciados del submundo criminal, el Gobierno de EE. UU. y la industria del entretenimiento. Tendr�n que llevar a cabo una serie de peligrosos golpes para sobrevivir en una ciudad implacable en la que no pueden confiar en nadie, y mucho menos los unos en los otros.
		Los jugadores actuales de juegos de PC pueden transferir tanto el progreso del modo historia de GTAV como los personajes y el progreso de GTA Online con una migraci�n �nica de la versi�n heredada de GTAV a GTAV Enhanced.') --descripci�n

		,(
		'Hogwarts Legacy'--nombre del juego
		,'SO: Windows 10.Memoria: 16 GB.Almacenamiento: 85 GB.'--requisitos minimos
		,'SO: Windows 10.Memoria: 16 GB.Almacenamiento: 85 GB.'--requisitos recomendados
		,999 --precio en pesos mexicanos
		,'Avalanche Software'--desarrollador
		,'2023-02-10'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaHogwarts.jpg'--portada
		,'/imagenes/imagenesJuegos/HowartsUno'--imagenes
		,'/imagenes/imagenesJuegos/HowartsDos'
		,'/imagenes/imagenesJuegos/HowartsTres'
		,0 --categor�a
		,'Hogwarts Legacy es un RPG de acci�n en un mundo abierto ambientado en el universo de los libros de Harry Potter. Emb�rcate en una aventura 		que te llevar� por lugares nuevos y conocidos, mientras descubres animales m�gicos, personalizas tu personaje, elaboras pociones, dominas 		hechizos, mejoras tus talentos y te conviertes en el mago que siempre has querido ser.
		Disfruta de Hogwarts en el siglo XIX. Tu personaje es un estudiante que tiene la clave de un antiguo secreto que amenaza con destruir el 		mundo m�gico. Haz aliados, lucha contra magos tenebrosos y decide el destino del mundo m�gico. Crea tu propio legado. Escribe tu propia 		historia.') --descripci�n

		,(
		'Mortal Kombat 1'--nombre del juego
		,'SO: Windows 10 de 64 bits.Memoria: 8 GB.Almacenamiento: 140 GB.'--requisitos minimos
		,'SO: Windows 10/11 de 64 bits.Memoria: 8 GB.Almacenamiento: 140 GB.'--requisitos recomendados
		,699.00 --precio en pesos mexicanos
		,'NetherRealm Studios.Saber Interactive.Shiver Entertainment'--desarrollador
		,'2023-09-14'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaMortalKombat.jpg'--portada
		,'/imagenes/imagenesJuegos/MortalKombatUno'--imagenes
		,'/imagenes/imagenesJuegos/MortalKombatDos'
		,'/imagenes/imagenesJuegos/MortalKombatTres'
		,0 --categor�a
		,'�Lo llevamos en la sangre!
		Descubre el nuevo universo de Mortal Kombat, creado por el Dios del Fuego Liu Kang. �Mortal Kombat 1 marca el comienzo de una nueva era para la ic�nica franquicia, con un sistema de lucha, modos de juego y Fatalities nuevos!') --descripci�n

		,(
		'Battlefield V'--nombre del juego
		,'SO: Windows 10 (64 bits).Memoria: 8 GB.Almacenamiento: 50 GB.'--requisitos minimos
		,'SO: Windows 10 de 64 bits o posterior.Memoria: 12 GB.Almacenamiento: 50 GB.'--requisitos recomendados
		,1199 --precio en pesos mexicanos
		,'Criterion Games.DICE (Digital Illusions CE)'--desarrollador
		,'2018-11-20'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaBattlefield.jpg'--portada
		,'/imagenes/imagenesJuegos/BattlefieldUno'--imagenes
		,'/imagenes/imagenesJuegos/BattlefieldDos'
		,'/imagenes/imagenesJuegos/BattlefieldTres'
		,0 --categor�a
		,'Tormenta de fuego: Battle Royale, reimaginado para Battlefield
		Domina el mapa m�s grande de Battlefield hasta el momento con armas y veh�culos de combate �picos mientras se acerca un c�rculo de fuego letal. Busca recursos, pelea y sobrevive para ser el �ltimo escuadr�n que quede en pie.
		La Segunda Guerra Mundial como nunca la viste
		Battlefield regresa a donde comenz� todo y lleva la lucha a momentos inesperados pero cruciales de la guerra.'); --descripci�n

insert into juegos(nombreJuego,rMinimos,rRecomendados,precio,desarrollador,fechaLanzamiento,
				portada,imagenUno,imagenDos,imagenTres,categoria,descripcion)
values(		
		'God Of War Ragnar�k'--nombre del juego
		,'SO: Windows 10 64-bit.Memoria: 8 GB.Almacenamiento: 190 GB.'--requisitos minimos
		,'SO: Windows 10 64-bit.Memoria: 16 GB.Almacenamiento: 190 GB.'--requisitos recomendados
		,999 --precio en pesos mexicanos
		,'Santa Monica Studio'--desarrollador
		,'2022-11-09'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaGodOfWar.jpg'--portada
		,'/imagenes/imagenesJuegos/GodOfWarUno'--imagenes
		,'/imagenes/imagenesJuegos/GodOfWarDos'
		,'/imagenes/imagenesJuegos/GodOfWarTres'
		,0 --categor�a
		,'Desde Santa Monica Studio llega la secuela del aclamado por la cr�tica God of War (2018). Emb�rcate en un viaje �pico y sincero, en el que Kratos y Atreus luchan por resistir y soltar. Llega a PC gracias a Jetpack Interactive.
		Contra el trasfondo de los nueve reinos n�rdicos desgarrados en polos opuestos por la furia de los aesir, se esfuerzan al m�ximo para evitar el fin del mundo. Pero a pesar de todo su esfuerzo, el Fimbulvetr avanza a toda velocidad.') --descripci�n

		,(
		'Horizon: Zero Dawn'--nombre del juego
		,'SO: Windows 10 de 64 bits (versi�n 1909 o posterior).Memoria: 16 GB de RAM.Almacenamiento: 135 GB de espacio disponible en SSD.'--requisitos minimos
		,'SO: Windows 10 de 64 bits (versi�n 1909 o posterior).Memoria: 16 GB de RAM.Almacenamiento: 135 GB de espacio disponible en SSD.'--requisitos recomendados
		,829 --precio en pesos mexicanos
		,'Guerrilla Games.Nixxes Software'--desarrollador
		,'2017-02-28'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaHorizon.jpg'--portada
		,'/imagenes/imagenesJuegos/HorizonUno'--imagenes
		,'/imagenes/imagenesJuegos/HorizonDos'
		,'/imagenes/imagenesJuegos/HorizonTres'
		,0 --categor�a
		,'Explora un mundo vasto y vibrante plagado de temibles m�quinas y misteriosas ruinas de una civilizaci�n extinta, ahora remasterizado con impresionantes gr�ficos y nuevas funcionalidades para PC.
		Empu�a el arco y la lanza de Aloy, una joven cazadora de m�quinas y paria de su tribu, mientras descubre sus or�genes, la verdad sobre su misterioso mundo, y su destino para salvarlo de una inminente cat�strofe. En sus viajes, Aloy conocer� tribus �nicas, asentamientos llenos de vida, y personajes y compa�eros de lo m�s interesantes.') --descripci�n

		,(
		'Returnal'--nombre del juego
		,'SO: Windows 10 (versi�n de 64 bits) (versi�n 1903.Memoria: 16 GB DDR4.Almacenamiento: 60 GB de espacio disponible en disco (SSD recomendado).'--requisitos minimos
		,'SO: Windows 10 (versi�n de 64 bits) (versi�n 1903.Memoria: 16 GB DDR4.Almacenamiento: 60 GB (SSD).'--requisitos recomendados
		,999 --precio en pesos mexicanos
		,'XDev Studios Europe.Housemarque'--desarrollador
		,'2021-04-30'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaReturnal.jpg'--portada
		,'/imagenes/imagenesJuegos/ReturnalUno'--imagenes
		,'/imagenes/imagenesJuegos/ReturnalDos'
		,'/imagenes/imagenesJuegos/ReturnalTres'
		,0 --categor�a
		,'Rompe el ciclo con este premiado juego de disparos en tercera persona que trae la acci�n del infierno de balas a la PC. La odisea roguelike de Selene llega con una serie de impresionantes mejoras gr�ficas y de rendimiento para garantizar una traves�a inolvidable.
		Tras estrellarse en este mundo que cambia de forma, Selene debe atravesar el est�ril paisaje de una antigua civilizaci�n para hallar una salida. Aislada y sola, se encuentra luchando con u�as y dientes por sobrevivir. Al ser derrotada una y otra vez, se ve obligada a reiniciar su traves�a cada vez que muere.') --descripci�n

		,(
		'Marvel s Spider-Man: Miles Morales'--nombre del juego
		,'SO: Windows 10 de 64 bits.Memoria: 8 GB de RAM.Almacenamiento: 75 GB de espacio en disco duro.'--requisitos minimos
		,'SO: Windows 10 de 64 bits.Memoria: 16 GB de RAM.Almacenamiento: 75 GB de espacio en disco duro (SSD).'--requisitos recomendados
		,829 --precio en pesos mexicanos
		,'XDev Studios Europe.Housemarque'--desarrollador
		,'2021-04-30'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaSpiderMan.jpg'--portada
		,'/imagenes/imagenesJuegos/SpiderManUno'--imagenes
		,'/imagenes/imagenesJuegos/SpiderManDos'
		,'/imagenes/imagenesJuegos/SpiderManTres'
		,0 --categor�a
		,'Luego de los eventos de Marvels Spider-Man Remasterizado, el adolescente Miles Morales intenta adaptarse a la vida en su nuevo hogar intentando seguir los pasos de su mentor, Peter Parker, como el nuevo Spider-Man. Pero cuando una terrible lucha de poder amenaza con destruir su hogar, el aspirante a h�roe comprende que un gran poder conlleva una gran responsabilidad. Para lograr salvar la ciudad de Nueva York de Marvel, Miles deber� cargar con la responsabilidad de ser Spider-Man.') --descripci�n

		,(
		'The Last of Us Part I'--nombre del juego
		,'SO: Windows 10 de 64 bits (versi�n 1909 o posterior).Memoria: 16 GB.Almacenamiento: 100 GB (SSD).'--requisitos minimos
		,'SO: Windows 10 de 64 bits (versi�n 1909 o posterior).Memoria: 16 GB.Almacenamiento: 100 GB (SSD).'--requisitos recomendados
		,999 --precio en pesos mexicanos
		,'Naughty Dog Software'--desarrollador
		,'2013-06-14'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaTheLastOfUs.jpg'--portada
		,'/imagenes/imagenesJuegos/TheLastOfUsUno'--imagenes
		,'/imagenes/imagenesJuegos/TheLastOfUsDos'
		,'/imagenes/imagenesJuegos/TheLastOfUsTres'
		,0 --categor�a
		,'Experimenta la emocionante historia y los inolvidables personajes de The Last of Us�, ganador de m�s de 200 premios Juego del A�o.
		En una civilizaci�n devastada donde se enfrentan infectados e insensibilizados sobrevivientes, alguien contrata a Joel, el cansado protagonista, para que escabulla en secreto a Ellie, de 14 a�os, fuera de una zona militar de cuarentena. Sin embargo, lo que comienza como un peque�o trabajo se convierte en un viaje brutal a trav�s del pa�s.') --descripci�n

		,(
		'UNCHARTED: Colecci�n Legado de ladrones'--nombre del juego
		,'SO: Windows 10 de 64 bits.Memoria: 8 GB.Almacenamiento: 126 GB en HDD.'--requisitos minimos
		,'SO: Windows 10 de 64 bits.Memoria: 16 GB.Almacenamiento: 126 GB en SDD.'--requisitos recomendados
		,829 --precio en pesos mexicanos
		,'Naughty Dog Software.Iron Galaxy Studios'--desarrollador
		,'2022-01-28'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaUncharted.jpg'--portada
		,'/imagenes/imagenesJuegos/UnchartedUno'--imagenes
		,'/imagenes/imagenesJuegos/UnchartedDos'
		,'/imagenes/imagenesJuegos/UnchartedTres'
		,0 --categor�a
		,'Ganador de m�s de 150 premios "Game of the Year".
		Varios a�os despu�s de su �ltima aventura, el cazafortunas retirado Nathan Drake debe volver al mundo de los ladrones. El destino llama a su puerta cuando Sam, el hermano de Drake que se presum�a muerto, regresa en busca de ayuda para salvar su propia vida y tentar a Drake con una aventura irresistible. En la aventura m�s importante de su vida, Drake pondr� a prueba sus l�mites f�sicos, su determinaci�n y, en �ltima instancia, lo que est� dispuesto a sacrificar para salvar a sus seres queridos. Sam y Drake salen en busca del tesoro perdido del capit�n Henry Avery y emprenden camino hacia Libertalia, una presunta colonia pirata ut�pica ubicada en lo profundo de los bosques de Madagascar. Ambos emprenden un viaje alrededor del mundo, en el que pasan por islas selv�ticas, ciudades remotas y picos nevados en busca del tesoro de Avery.'); --descripci�n

insert into juegos(nombreJuego,rMinimos,rRecomendados,precio,desarrollador,fechaLanzamiento,
				portada,imagenUno,imagenDos,imagenTres,categoria,descripcion)
values(
		'Mario Kart 8 Deluxe'--nombre del juego
		,'SO: Nintendo Switch.Memoria: 4 GB.Almacenamiento: 11.3 GB.'--requisitos minimos
		,'SO: Nintendo Switch.Memoria: 4 GB.Almacenamiento: 11.3 GB.'--requisitos recomendados
		,1399.00 --precio en pesos mexicanos
		,'Nintendo Entertainment Analysis & Development (EAD)'--desarrollador
		,'2017-04-28'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaMarioKart.jpg'--portada
		,'/imagenes/imagenesJuegos/MarioKartUno'--imagenes
		,'/imagenes/imagenesJuegos/MarioKartDos'
		,'/imagenes/imagenesJuegos/MarioKartTres'
		,3 --categor�a
		,'�Acelera a trav�s de las pistas del Reino Champi��n bajo el agua, en el cielo, de cabeza y sin gravedad, y llega a la meta para obtener la victoria! Prepara motores en el modo multijugador local*, en los torneos en l�nea** del juego, en el modo batalla que ha sido mejorado �y m�s!') --descripci�n

		,(
		'The Legend of Zelda: Tears of the Kingdom'--nombre del juego
		,'SO: Nintendo Switch.Memoria: 4 GB.Almacenamiento: 16.3 GB.'--requisitos minimos
		,'SO: Nintendo Switch.Memoria: 4 GB.Almacenamiento: 16.3 GB.'--requisitos recomendados
		,1599.00 --precio en pesos mexicanos
		,'Nintendo Entertainment Planning & Development (EPD)'--desarrollador
		,'2023-05-12'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaZeldaTK.jpg'--portada
		,'/imagenes/imagenesJuegos/ZeldaTKUno'--imagenes
		,'/imagenes/imagenesJuegos/ZeldaTKDos'
		,'/imagenes/imagenesJuegos/ZeldaTKTres'
		,2 --categor�a
		,'Una �pica aventura a trav�s de la superficie y los cielos de Hyrule te espera en The Legend of Zelda�: Tears of the Kingdom, disponible exclusivamente para la consola Nintendo Switch.
		En esta secuela del juego The Legend of Zelda: Breath of the Wild, decidir�s tu propio camino a trav�s de los extensos paisajes de Hyrule y las islas que flotan en los vastos cielos. �Podr�s aprovechar el poder de las nuevas habilidades de Link para luchar contra las mal�volas fuerzas que amenazan al reino?') --descripci�n

		,(		
		'Super Mario Odyssey'--nombre del juego
		,'SO: Nintendo Switch.Memoria: 4 GB de RAM.Almacenamiento: 5.6 GB.'--requisitos minimos
		,'SO: Nintendo Switch.Memoria: 4 GB de RAM.Almacenamiento: 5.6 GB.'--requisitos recomendados
		,1399.00 --precio en pesos mexicanos
		,'1-Up Studio.Nintendo Entertainment Planning & Development (EPD)'--desarrollador
		,'2017-10-27'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaMarioOdyssey.jpg'--portada
		,'/imagenes/imagenesJuegos/MarioOdysseyUno'--imagenes
		,'/imagenes/imagenesJuegos/MarioOdysseyDos'
		,'/imagenes/imagenesJuegos/MarioOdysseyTres'
		,3 --categor�a
		,'Explora incre�bles lugares lejos del reino Champi��n al unirte a Mario y su nuevo amigo Cappy en una incre�ble aventura al mejor estilo trotamundos en 3D. Usa asombrosas habilidades como: el poder de capturar y controlar objetos, animales y enemigos; para conseguir energilunas necesarias para recargar la nave Odyssey y salvar a la princesa Peach de los planes de boda de Bowser.
		Los nuevos movimientos de Mario como el salto gorra, lanzar la gorra y captura, te har�n pensar de nuevo en su tradicional corre y brinca, y esto gracias al h�roe con forma de sombrero, Cappy. Utiliza los enemigos, objetos y animales capturados para avanzar en el juego y descubrir grandes cantidades de objetos ocultos coleccionables.') --descripci�n

		,(
		'Super Mario Party Jamboree'--nombre del juego
		,'SO: Nintendo Switch.Memoria: 4 GB de RAM.Almacenamiento: 5.3 GB.'--requisitos minimos
		,'SO: Nintendo Switch.Memoria: 4 GB de RAM.Almacenamiento: 5.3 GB.'--requisitos recomendados
		,1399.00 --precio en pesos mexicanos
		,'Nintendo Cube'--desarrollador
		,'2024-10-17'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaMarioParty.jpg'--portada
		,'/imagenes/imagenesJuegos/MarioPartyUno'--imagenes
		,'/imagenes/imagenesJuegos/MarioPartyDos'
		,'/imagenes/imagenesJuegos/MarioPartyTres'
		,4 --categor�a
		,'�La serie Mario Party est� de regreso y ofrece a�n m�s diversi�n! Con m�s de 110 minijuegos, nuevos modos en l�nea* y sin conexi�n** y una gran cantidad de opciones de personalizaci�n, �hay algo incre�ble para todos!') --descripci�n

		,(
		'Pok�mon Violet'--nombre del juego
		,'SO: Nintendo Switch.Memoria: 4 GB de RAM.Almacenamiento: 9.9 GB.'--requisitos minimos
		,'SO: Nintendo Switch.Memoria: 4 GB de RAM.Almacenamiento: 9.9 GB.'--requisitos recomendados
		,1399.00 --precio en pesos mexicanos
		,'Game Freak'--desarrollador
		,'2022-11-18'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaPokemonViolet.jpg'--portada
		,'/imagenes/imagenesJuegos/PokemonVioletUno'--imagenes
		,'/imagenes/imagenesJuegos/PokemonVioletDos'
		,'/imagenes/imagenesJuegos/PokemonVioletTres'
		,1 --categor�a
		,'Bienvenidos al mundo abierto de la regi�n de Paldea
		Atrapa, combate y entrena Pok�mon en la regi�n de Paldea, una vasta tierra llena de lagos, cimas monta�osas, p�ramos, poblaciones peque�as y grandes ciudades. Explora un mundo completamente abierto a tu propio paso y recorre a trav�s de la tierra, el agua y el aire a lomos del Pok�mon legendario Koraidon, que puede cambiar de forma en Pok�mon Scarlet, o sobre el Pok�mon legendario Miraidon, que puede cambiar de forma en Pok�mon Violet. Elige entre Sprigatito, Fuecoco o Quaxly para que sea tu primer compa�ero Pok�mon antes de lanzarte en tu aventura a trav�s de Paldea') --descripci�n

		,(
		'Super Smash Bros. Ultimate'--nombre del juego
		,'SO: Nintendo Switch.Memoria: 4 GB de RAM.Almacenamiento: 17.3 GB.'--requisitos minimos
		,'SO: Nintendo Switch.Memoria: 4 GB de RAM.Almacenamiento: 17.3 GB.'--requisitos recomendados
		,1399.00 --precio en pesos mexicanos
		,'Bandai Namco Games.Sora Ltd'--desarrollador
		,'2018-12-07'--fecha de lanzamiento fortato yyyy-mm-dd
		,'/imagenes/imagesJuegos/PortadaSuperSmash.jpg'--portada
		,'/imagenes/imagenesJuegos/SuperSmashUno'--imagenes
		,'/imagenes/imagenesJuegos/SuperSmashDos'
		,'/imagenes/imagenesJuegos/SuperSmashTres'
		,0 --categor�a
		,'�Un aut�ntico duelo de titanes de los videojuegos que podr�s jugar cuando quieras y donde quieras! Lanza a tus rivales del escenario usando uno de los nuevos personajes como Simon Belmont o King K. Rool que se unen a Inkling, Ridley y a todos los combatientes presentes en la historia de Super Smash Bros. Disfruta de la velocidad mejorada y combate en los nuevos escenarios basados en las series de Castlevania, Super Mario Odyssey y otras.'); --descripci�n

		--linea 681
select * from juegos

