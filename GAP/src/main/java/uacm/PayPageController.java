package uacm;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.Juego;

/**
 * FXML Controller class
 *
 * @author Frncs.Fox
 */
public class PayPageController implements Initializable {

    @FXML
    private Label precio_lbl;
    @FXML
    private Label total_lbl;
    @FXML
    private Button pagar_bttn;
    @FXML
    private GridPane gridPane_Juegos;
    @FXML
    private ToggleGroup pago_selection;
    @FXML
    private GridPane gridPane_Tarjetas;   

    private void mostrarJuegos(List<Juego> juegos, GridPane contenedor){
        
        contenedor.getChildren().clear();       
        contenedor.setAlignment(Pos.TOP_CENTER);
        
        int columnas = 1;
        int fila = 0;
        int columna = 0;
        
        for(Juego juego : juegos){
            // Crear ImageView, una por cada juego
            ImageView imageView = new ImageView();
            imageView.setFitHeight(100);
            imageView.setPreserveRatio(true);
            
            String ruta = juego.getImagenes()[0]; //cargar la imagen Portada
            try {
                Image imagen = new Image(getClass().getResource(ruta).toExternalForm());
                imageView.setImage(imagen);
            } catch (Exception e) {
                System.out.println("No se pudo cargar la imagen: " + ruta);
            }
            
            // Crear etiquetas para cada juego
            Label nombre = new Label(juego.getNombreJuego());
            Label precio = new Label(String.format("$" + "%.2f", juego.getPrecio()));
            nombre.setTextFill(Color.WHITE);
            precio.setTextFill(Color.WHITE);
            
            HBox contenedorJuego = new HBox(10, imageView, nombre, precio);
            contenedorJuego.setAlignment(Pos.CENTER);
            
            contenedor.add(contenedorJuego, columna, fila);
            
            columna++;
            if (columna == columnas) {
                columna = 0;
                fila++;
            }    
        }
    }
    
    private Juego juegoSeleccionado;
    
    public void cargarJuegoDesdePagina(Juego juego) {
        this.juegoSeleccionado = juego;
        List<Juego> juegos = new ArrayList<>();
        juegos.add(juego);
        mostrarJuegos(juegos, gridPane_Juegos);
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
