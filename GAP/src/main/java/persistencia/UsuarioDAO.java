package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.Juego;
import logic.Usuario;
import logic.ValidadorCorreo;

public class UsuarioDAO {

    private Connection conexionBase; // establece la conexion activa con la base de datos
    private ResultSet res; // me permite acceder al resultado de una consulta en la base de datos
    private Statement consulta;

    public UsuarioDAO() throws SQLException {
        conexionBase = Conexion.gConnection();// se hace la conexion a la base de datos
        // isValid me dice si la conxion es validada
        System.out.println(conexionBase.isValid(1000) ? "conexon exitosa" : "fallo en la conexion");
    }

    /**
     * Metodo cargaUsuario hace una consulta a la base de datos y me regresa una
     * lista con los usuarios que estan en la base los valores de id, nombre,
     * email, password, ajoloCoins y saldo no puedes ser null, la tarjeta de
     * credito y la foto de perfil si pueden ser null en especila si los
     * usuarios son nuevos
     *
     * @return
     */
    public List<Usuario> cargaUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {

            consulta = conexionBase.createStatement();// consulta me permite realizar consultas a la base
            res = consulta.executeQuery("SELECT * FROM usuario");// consuta que se realiza en la base
            while (res.next()) {
                Usuario usuario = new Usuario();
                // obteniendo los valores que guardan en la variable res
                usuario.setId(res.getInt("id"));
                usuario.setUsuario(res.getString("nombre"));
                usuario.setEmail(res.getString("email"));
                usuario.setPasword(res.getString("password"));
                usuario.setAjoloCoins(res.getInt("ajoloCoins"));


                byte[] imagenperfil = res.getBytes("fotoPerfil");//la foto se almacena como bytes
                if (res.wasNull()) {//res.wasNull me dice si el valor anterior es valido
                    usuario.setImagenPerfil(null);
                } else {// si mi dato anterios de res no es null asigno la foto de perfil
                    usuario.setImagenPerfil(imagenperfil);
                }
                
                
                usuario.setSaldo(res.getInt("saldo"));
                
                usuario.setFechaNacimiento(res.getDate("fechaNacimiento"));
                
                listaUsuarios.add(usuario);
                listaUsuarios.add(usuario);// añadiendo los usuarios a la lista

            }
            return listaUsuarios;

        } catch (SQLException e) {
            System.out.println("Error en cargaUsuarios: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al cargar usuarios: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo agergarUsuarioBD raliza una consulta en la base de datos solo
     * carga en la base de datos el nombre del usuario, correo, password y su
     * fecha de nacimiento por defecto los ajoloCois y el saldo se inicializan
     * en cero
     *
     * @param usuario
     */
    public void agregarUsuarioBD(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuario(nombre, email, password, ajoloCoins, saldo, fechaNacimiento) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conexionBase.prepareStatement(sql);
            
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getPasword());
            pstmt.setInt(4, 0);
            pstmt.setDouble(5, 0.0);
            pstmt.setDate(6, usuario.getFechaNacimiento());
            
            pstmt.executeUpdate();
            System.out.println("Usuario almacenado exitosamente en la base de datos!!!!!!!!!");
            
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
            e.printStackTrace();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Usuario buscaUsuario(String cadena) {

        try {
            String sql = tipoConsulta(cadena);
            PreparedStatement pstmt = conexionBase.prepareStatement(sql);
            pstmt.setString(1, cadena);
            res = pstmt.executeQuery();
            
            if (res.next()) {
                Usuario buscado = new Usuario();
                buscado.setId(res.getInt("id"));
                buscado.setUsuario(res.getString("nombre"));
                buscado.setEmail(res.getString("email"));
                buscado.setPasword(res.getString("password"));
                buscado.setAjoloCoins(res.getInt("ajoloCoins"));

                // manejo de valores null de la base de datos
                byte[] imagenperfil = res.getBytes("fotoPerfil");// la foto se almacena como bytes
                if (res.wasNull()) {// res.wasNull me dice si el valor anterior es null
                    buscado.setImagenPerfil(null);
                } else {// si mi dato anterios de res no es null asigno la foto de perfil
                    buscado.setImagenPerfil(imagenperfil);
                }
                
                buscado.setSaldo(res.getInt("saldo")); 
                buscado.setFechaNacimiento(res.getDate("fechaNacimiento"));
                
                return buscado;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al buscar usuario: " + e.getMessage(), e);
        }

        return null; // me regresa null si no existe el usuario en la base de datos
    }

    public Usuario obtenerPorId(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (Connection conn = Conexion.gConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            res = stmt.executeQuery();

            if (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(res.getInt("id"));
                usuario.setUsuario(res.getString("nombre"));
                usuario.setEmail(res.getString("email"));
                usuario.setPasword(res.getString("password"));
                usuario.setAjoloCoins(res.getInt("ajoloCoins"));

                byte[] imagenperfil = res.getBytes("fotoPerfil");
                if (res.wasNull()) {
                    usuario.setImagenPerfil(null);
                } else {
                    usuario.setImagenPerfil(imagenperfil);
                }

                usuario.setSaldo(res.getInt("saldo"));
                usuario.setFechaNacimiento(res.getDate("fechaNacimiento"));

                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error en obtenerPorId: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al obtener usuario por ID", e);
        }
        return null; // Si no se encontró el usuario
    }

    
    /**
     * Tenemos dos tipos de consutas se ejecutara una u otra dependiendo de si se
     * ingrese en la pantalla de login
     * el correo electronico o el nombre del usuario
     * Me regresa una cadena con PreparedStatement.
     * Si se ingreso el correo electronico me regresa la cadena:
     *  "SELECT * FROM usuario WHERE email = ?"
     * Si se ingreso el nombre del usuario me regresa la cadena:
     * "SELECT * FROM usuario WHERE nombre = ?"
     * 
     */
    private String tipoConsulta(String cadena) {
        if (ValidadorCorreo.validarCorreo(cadena)) { //si es un correo se busca en la base por el correo
            return "SELECT * FROM usuario WHERE email = ?";
        } else {//se busca por el nombre en la base de datos
            return "SELECT * FROM usuario WHERE nombre = ?";
        }
    }

    public boolean updateEmail(int id, String nuevoEmail) {
        try (
            Connection conn = Conexion.gConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET email = ? WHERE id = ?")) {
            stmt.setString(1, nuevoEmail);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar email: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePasword(int id, String nuevaContrasenha) {
        try (Connection conn = Conexion.gConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET password = ? WHERE id = ?")) {
            stmt.setString(1, nuevaContrasenha);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar password: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNombre(int id, String nuevoNombre) {
        try (Connection conn = Conexion.gConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET nombre = ? WHERE id = ?")) {
            stmt.setString(1, nuevoNombre);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar nombre: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateFotoPerfil(int id, byte[] imagenPerfil) {
        try (Connection conn = Conexion.gConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET fotoPerfil = ? WHERE id = ?")) {
            stmt.setBytes(1, imagenPerfil);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar foto de perfil: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateAjolocoins(int idUsuario, int cantidadSumar){
        try(Connection conn = Conexion.gConnection();
            PreparedStatement stmt = conn.prepareStatement( "UPDATE usuario SET ajoloCoins = ajoloCoins + ? WHERE id = ?")){
            
            stmt.setInt(1, cantidadSumar);//cuantos axolocoins se quieren sumar
            stmt.setInt(2, idUsuario);//a que usuario 
            
            return stmt.executeUpdate() > 0;// Devuelve true si se actualizó al menos una fila
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean setAjolocoins(int idUsuario, int nuevoValor) {
        try (Connection conn = Conexion.gConnection(); PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET ajoloCoins = ? WHERE id = ?")) {

            stmt.setInt(1, nuevoValor); // asignar nuevo valor directamente
            stmt.setInt(2, idUsuario);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateContrasena(int idUsuario, String contraseña){
        try{
            Connection conexion = Conexion.gConnection();
            PreparedStatement stmt = conexion.prepareStatement("UPDATE usuario SET password = ? where id = ?");
            stmt.setString(1, contraseña);
            stmt.setInt(2, idUsuario);
            
            
            return stmt.executeUpdate() > 0;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
       
    }

    public boolean asignarJuegoUsuario(int idUsuario, int idJuego){
        String sql = "INSERT INTO usuario_juego (idUsuario, idJuego) VALUES(?, ?)";
        
        try(Connection conn = Conexion.gConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idJuego);
            
            stmt.executeUpdate();
            return true;
            
        }catch(SQLIntegrityConstraintViolationException e){
            System.out.println("El usuario ya tiene este juego registrado");
            return false;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Juego> JuegosUsuario(int idUsuario) {
        
        List<Juego> lisJuegos = new ArrayList<>();
        try {
            consulta = conexionBase.createStatement();
            // obtengo los valores del juego
            res = consulta.executeQuery("select j.idJuego, j.nombreJuego," +
                    "j.portada," +
                    "j.imagenUno,j.imagenDos," +
                    "j.imagenTres" +
                    " from usuario_juego uj join juegos j on j.idJuego = uj.idJuego where uj.idUsuario = " + idUsuario);
            while (res.next()) {
                //System.out.println("Juego encontrado: " + res.getString("nombreJuego"));
                Juego game = new Juego();
                game.setIdJuego(res.getInt("idJuego"));
                game.setNombreJuego(res.getString("nombreJuego"));
                String[] imagenes = new String[4];
                imagenes[0] = res.getString("portada");
                imagenes[1] = res.getString("imagenUno");
                imagenes[2] = res.getString("imagenDos");
                imagenes[3] = res.getString("imagenTres");
                game.setImagenes(imagenes);
                lisJuegos.add(game);
                
            }

            return lisJuegos;
            
        } catch (SQLException e) {
          throw  new RuntimeException();
        }
    }

}
