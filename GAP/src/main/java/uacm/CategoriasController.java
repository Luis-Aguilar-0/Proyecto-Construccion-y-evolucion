package uacm;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import logic.Juego;
import persistencia.JuegoDAO;
import uacm.utilities.PathsImages;

/**
 * FXML Controller class
 *
 * @author Frncs.Fox
 */
public class CategoriasController implements Initializable {

    @FXML
    private FlowPane contenedorJuegos;
    @FXML
    private ImageView imagen1;
    @FXML
    private Button accion_btn;

    JuegoDAO juegoDAO;
    
    private PathsImages images;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
            juegoDAO = new JuegoDAO();
            List<Juego> juegos = juegoDAO.cargaJuegos();//recuperar la lista de juegos
            
            if(!juegos.isEmpty()){
                String rutaImagen = juegos.get(0).getImagenes()[0];
                accion_btn.setOnAction(event -> {
                    Image imagen = new Image(rutaImagen);
                    imagen1.setImage(imagen);

                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
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
