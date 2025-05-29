package uacm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.Juego;
// Es buena práctica tener una referencia al controlador principal del carrito
// si los artículos necesitan comunicarse (ej. para eliminarse)

public class ObjetoCarritoController {

    @FXML
    private ImageView imgGameCover;

    @FXML
    private Label lblNombreJuego; // Parece estar en tu FXML, aunque no se solicitó explícitamente para mostrar

    @FXML
    private Label lblPrecioJuegoMXN; // Para el precio en MXN

    @FXML
    private Label lblPrecioJuegoAC; // Nueva Label para Axolocoins

    @FXML
    private Button btnEliminarJuego;

    private Juego juegoActual; // Almacena el objeto Juego actual
    private CarritoController carritoController; // Referencia al controlador principal del carrito

    @FXML
    private void handleRemoveItem() {
        if (juegoActual != null && carritoController != null) {
            // Notifica al controlador principal del carrito para eliminar este artículo
            // El itemNode (el AnchorPane o raíz de ObjetoCarrito.fxml)
            // se puede obtener desde cualquiera de sus elementos FXML hijos.
            carritoController.removerJuegoDelCarrito(juegoActual, lblNombreJuego.getParent());
        }
    }

    public void setData(Juego juego, CarritoController carritoCtrl) {
        this.juegoActual = juego;
        this.carritoController = carritoCtrl;

        lblNombreJuego.setText(juego.getNombreJuego());

        // Mostrar precio en MXN
        lblPrecioJuegoMXN.setText(String.format("$%.2f MXN", juego.getPrecio()));

        // Mostrar precio en Axolocoins
        if (juego.getPrecioAjoloCoins() != null && juego.getPrecioAjoloCoins() > 0) { //
            lblPrecioJuegoAC.setText(String.format("%d AC", juego.getPrecioAjoloCoins())); //
        } else {
            lblPrecioJuegoAC.setText("Sin definir"); // O "No disponible en AC"
        }

        // Cargar imagen de portada del juego
        try {
            String imagePath = juego.getPortada(); 
            if (imagePath != null && !imagePath.isEmpty()) {
                Image coverImage = new Image(getClass().getResourceAsStream(imagePath));
                imgGameCover.setImage(coverImage);
            } else {
                System.err.println("La ruta de la imagen de portada es nula o está vacía para: " + juego.getNombreJuego());
            }
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen de portada para " + juego.getNombreJuego() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}