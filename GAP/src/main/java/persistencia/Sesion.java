package persistencia;
import logic.Usuario;
// funcion? guarda en memoria el usuario que ha iniciado sesion
public class Sesion {
    private static Usuario usuarioActual;//copia del usuario que ha iniciado sesion

    public static void setUsuario(Usuario u) {//se llama al usuario tras haber inciado sesion
        usuarioActual = u;
      }
      public static Usuario getUsuario() { //obtiene los datos del usuario que inicio sesion
        return usuarioActual;
      }
      public static void cerrarUsuario() { //cierra la sesion del usuario
        usuarioActual = null;
      }
       /** Indica si hay alguien logueado */
  public static boolean isLoggedUsuario() {// te dice si hay alguien logeado
    return usuarioActual != null;
  }
}
