
package logic; 

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GestorCarrito {

    private static final ObservableList<Juego> itemsEnCarrito = FXCollections.observableArrayList();
    public static ObservableList<Juego> getObjetosEnCarrito() {
        return itemsEnCarrito;
    }

    public static void agregarJuego(Juego juego) {
        if (juego != null && !itemsEnCarrito.contains(juego)) {
            itemsEnCarrito.add(juego);
            System.out.println("GestorCarrito: Añadido " + juego.getNombreJuego());
        } else if (juego != null) {
            System.out.println("GestorCarrito: El juego " + juego.getNombreJuego() + " ya estaba en el carrito");
        }
    }

    public static void removerJuego(Juego juego) {
        if (juego != null) {
            itemsEnCarrito.remove(juego);
            System.out.println("GestorCarrito: eliminado " + juego.getNombreJuego());
        }
    }

    public static double getPrecioTotalMXN() {
        double total = 0;
        for (Juego juego : itemsEnCarrito) {
            total += juego.getPrecio();
        }
        return total;
    }

    public static int getNumeroTotalDeJuegos() {
        return itemsEnCarrito.size();
    }

}