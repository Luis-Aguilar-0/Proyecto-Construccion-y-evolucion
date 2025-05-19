package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.Juego;

public class JuegoDAO {

    private Connection conexion;
    private ResultSet resJuego;
  

    public JuegoDAO() throws SQLException {

        conexion = Conexion.gConnection();

        System.out.println(conexion.isValid(1000) ? "conexion exitos" : "fallo en la conexion");

    }

    // carga de los juegos
    public List<Juego> cargaJuegos() {

        List<Juego> listaJuegos = new ArrayList<>();
        try {

            Statement s = conexion.createStatement();
            resJuego = s.executeQuery("SELECT * FROM juegos");
            while (resJuego.next()) {
                Juego juego = new Juego();
                juego.setIdJuego(resJuego.getInt("idJuego"));
                juego.setNombreJuego(resJuego.getString("nombreJuego"));
                juego.setrMininos(resJuego.getString("rMinimos"));
                juego.setrRecomendados(resJuego.getString("rRecomendados"));
                juego.setPrecio(resJuego.getFloat("precio"));
                juego.setDesarrollador(resJuego.getString("desarrollador"));
                juego.setFechaLanzamiento( resJuego.getDate("fechaLanzamiento"));
                juego.setCategoria(resJuego.getInt("categoria"));

                int precioAjolo = resJuego.getInt("precioAjoloCoins");
                if(resJuego.wasNull()){
                    juego.setPrecioAjoloCoins(null);
                }else{
                    juego.setPrecioAjoloCoins(precioAjolo);
                }
                //se cargan las direcciones de las imagenes
                String[] imagenes = {resJuego.getString("portada"),
                                    resJuego.getString("imagenUno"),
                                    resJuego.getString("imagenDos"),
                                    resJuego.getString("imagenTres")}; 
                juego.setImagenes(imagenes);

                listaJuegos.add(juego);//se añaden los juegos a la lista



            }
            return listaJuegos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
