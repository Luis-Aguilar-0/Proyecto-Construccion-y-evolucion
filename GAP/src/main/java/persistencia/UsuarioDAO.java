package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.Usuario;

public class UsuarioDAO {

    private Connection conexionBase; //establece la conexion activa con la base de datos
    private ResultSet res; //me permite acceder al resultado de una consulta en la base de datos

    public UsuarioDAO() throws SQLException {

        conexionBase = Conexion.gConnection();// se hace la conexion a la base de datos
                            // isValid me dice si la conxion es validada
        System.out.println(conexionBase.isValid(1000) ? "conexon exitosa" : "fallo en la conexion");

    }

    /**
     * Metodo cargaUsuario hace una consulta a la base de datos y me regreda una lista con los usuarios que estan en la base
     * los valores de id, nombre, email, password, ajoloCoins y saldo no puedes ser null, la tarjeta de credito y la foto de perfil si pueden ser null
     * en especila si los usuarios son nuevos
     * 
     * @return
     */
    public List<Usuario> cargaUsuarios() {

        List<Usuario> listaUsuarios = new ArrayList<>();
        try {

            Statement usu = conexionBase.createStatement();//usu me permite realizar consultas a la base 
            res = usu.executeQuery("SELECT * FROM usuario");//consuta que se realiza en la base
            while (res.next()) {
                Usuario usuario = new Usuario();
                //obteniendo los valores que guardan en la variable res
                usuario.setId(res.getInt("id"));
                usuario.setUsuario(res.getString("nombre"));
                usuario.setEmail(res.getString("email"));
                usuario.setPasword(res.getString("password"));
                usuario.setAjoloCoins(res.getInt("ajoloCoins"));

                //manejo de valores null de la base de datos
                byte[] imagenperfil = res.getBytes("fotoPerfil");//la foto se almacena como bytes
                if(res.wasNull()){//res.wasNull me dice si el valor anterior es null
                    usuario.setImagenPerfil(null);
                }else{//si mi dato anterios de res no es null asigno la foto de perfil
                    usuario.setImagenPerfil(imagenperfil);
                }
                int idTarjeta = res.getInt("idTarjetaCredito");
                if (res.wasNull()) {
                    usuario.setIdTarjetaCredito(null);
                } else {
                    usuario.setIdTarjetaCredito(idTarjeta);
                }
                usuario.setSaldo(res.getInt("saldo"));
                listaUsuarios.add(usuario);//añadiendo los usuarios a la lista

            }

            return listaUsuarios;

        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    /**
     * Metodo agergarUsuarioBD raliza una consulta en la base de datos 
     * solo carga en la base de datos el nombre del usuario, correo, password y su fecha de nacimiento
     * por defecto los ajoloCois y el saldo se inicializan en cero
     * @param usuario
     */
    public void agregarUsuarioBD(Usuario usuario) {
        Statement s;

        try {
            s = conexionBase.createStatement();
            //dando formato a la fecha 
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //formato de años-meses-dias
            String fechaNacimiento = formato.format(usuario.getFechaNacimiento()); //le da el formato adecuado a la variable
            s.executeUpdate("INSERT INTO usuario(nombre,email,password,ajoloCoins,saldo,fechaNacimiento) VALUES('"
                    + usuario.getUsuario() + "','" + usuario.getEmail() + "','" + usuario.getPasword()+ "','" + 0 + "','" + 0.0 + "','" + fechaNacimiento
                    + "');");
            System.out.println("Usuario almacenado exitosamente en la base de datos!!!!!!!!!");
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
            
        

    }



    

}
