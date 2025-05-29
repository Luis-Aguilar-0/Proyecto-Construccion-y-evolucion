package persistencia;
import java.util.List;
import logic.Juego;
import logic.Usuario;
// funcion? guarda en memoria el usuario que ha iniciado sesion
public class Sesion {
    private static Usuario usuarioActual;//copia del usuario que ha iniciado sesion
    private static List<Juego> juegos;
    private static Juego juego;
    private static String pantallaOrigen;

    public static void setUsuario(Usuario u) {//se llama al usuario tras haber inciado sesion
        usuarioActual = u;
      }
      public static Usuario getUsuario() { //obtiene los datos del usuario que inicio sesion
        return usuarioActual;
      }
      public static void cerrarUsuario() { //cierra la sesion del usuario
        usuarioActual = null;
      }
      public static List<Juego> getJuegosUsuario(){
          return juegos;
      }
      public static void setJuegosUsuario(List<Juego> j){
          juegos = j;
      }
      public static Juego getJuegoPagina(){
        return juego;
      }
      public static void setJuegoPagina(Juego juego_){
        juego = juego_;
      }
      public static String getPantallaOrigen(){
        return pantallaOrigen;
      }
      public static void setPantallaOrigen(String origen){
        pantallaOrigen = origen;
      }

       /** Indica si hay alguien logueado */
  public static boolean isLoggedUsuario() {// te dice si hay alguien logeado
    return usuarioActual != null;
  }
}
