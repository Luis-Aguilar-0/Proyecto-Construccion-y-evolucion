package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JuegoDAO {

    private Connection conexion;
    private ResultSet resJuego;

    public JuegoDAO() throws SQLException {

        conexion = Conexion.gConnection();

        System.out.println(conexion.isValid(1000) ? "conexion exitos" : "fallo en la conexion");

    }

}
