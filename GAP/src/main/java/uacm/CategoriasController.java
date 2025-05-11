package uacm;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import logic.Juego;

/**
 * FXML Controller class
 *
 * @author Frncs.Fox
 */
public class CategoriasController implements Initializable {

    @FXML
    private FlowPane contenedorJuegos;

    public void mostrarJuegos(List<Juego> juegos) {
        contenedorJuegos.getChildren().clear(); // Limpiamos el FlowPane

        for (Juego juego : juegos) {
            VBox tarjeta = new VBox(5); // VBox para cada juego
            tarjeta.setAlignment(Pos.CENTER);
            tarjeta.setPadding(new Insets(10));

            // Cargar la imagen principal del juego
            String ruta = juego.getImagenes()[0]; // Solo usaremos la imagen 0
            Image imagen = new Image(getClass().getResourceAsStream("/imagenes/" + ruta));
            ImageView imageView = new ImageView(imagen);
            imageView.setFitWidth(120);
            imageView.setFitHeight(120);
            imageView.setPreserveRatio(true);

            // Nombre y precio
            Label nombre = new Label(juego.getNombreJuego());
            Label precio = new Label("$" + juego.getPrecion());

            // Agregamos a la tarjeta
            tarjeta.getChildren().addAll(imageView, nombre, precio);

            // Agregamos al FlowPane
            contenedorJuegos.getChildren().add(tarjeta);
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void mostrasPlataformas(ActionEvent event) {
    }

    @FXML
    private void mostrarPuzles(ActionEvent event) {
    }

    @FXML
    private void mostrarAccion(ActionEvent event) {
    }

    @FXML
    private void mostrarEstrategia(ActionEvent event) {
    }

    @FXML
    private void mostrarTerror(ActionEvent event) {
    }

    @FXML
    private void mostrarNarrativa(ActionEvent event) {
    }
    //agregar las imagenes manualmente y solo jalar el nombre y los precios de la base de datos
    
}
