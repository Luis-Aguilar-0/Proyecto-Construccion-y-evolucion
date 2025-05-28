package uacm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.Juego; // Asegúrate que esta clase Juego exista y sea la correcta

public class CartItemController {

    @FXML
    private ImageView imgGameCover;

    @FXML
    private Label lblGameName;

    @FXML
    private Label lblGameDeveloper;

    @FXML
    private Label lblGamePrice;

    @FXML
    private Button btnRemoveItem;

    private Juego juego;
    private CarritoController carritoController; // Referencia al controlador principal del carrito

    public void setData(Juego juego, CarritoController carritoController) {
        this.juego = juego;
        this.carritoController = carritoController;

        lblGameName.setText(juego.getNombreJuego());
        lblGameDeveloper.setText(juego.getDesarrollador()); // Asumiendo que Juego tiene getDesarrollador()
        lblGamePrice.setText(String.format("$%.2f", juego.getPrecio()));

        // Cargar imagen de portada
        // Asegúrate que la ruta de la imagen sea correcta y accesible desde los recursos
        try {
            String imagePath = juego.getImagenes()[0]; // Asumiendo que getImagenes()[0] es la portada
            if (imagePath != null && !imagePath.isEmpty()) {
                Image coverImage = new Image(getClass().getResourceAsStream(imagePath));
                imgGameCover.setImage(coverImage);
            } else {
                // Poner una imagen por defecto si no hay portada
                // imgGameCover.setImage(new Image(getClass().getResourceAsStream("/imagenes/default_cover.png")));
            }
        } catch (Exception e) {
            System.err.println("Error al cargar imagen para " + juego.getNombreJuego() + ": " + e.getMessage());
            // Opcional: Poner una imagen por defecto en caso de error
            // imgGameCover.setImage(new Image(getClass().getResourceAsStream("/imagenes/default_cover.png")));
        }
    }

    @FXML
    void handleRemoveItem(ActionEvent event) {
        if (carritoController != null && juego != null) {
            carritoController.removerJuegoDelCarrito(juego, (javafx.scene.Node) btnRemoveItem.getParent());
        }
    }
}