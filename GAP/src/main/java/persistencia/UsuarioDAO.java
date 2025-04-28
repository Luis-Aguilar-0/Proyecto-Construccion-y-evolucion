package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection conexionBase; //
    private ResultSet res; //
    

    public UsuarioDAO() throws SQLException{

        conexionBase = Conexion.gConnection();//se hace la conexion a la base de datos
                            //isValid me dice si la conxion es validada
        System.out.println(conexionBase.isValid(1000) ? "conexon exitosa" : "fallo en la conexion");

    }

    
}
