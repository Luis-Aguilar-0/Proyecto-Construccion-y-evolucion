package uacm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import java.io.IOException;
import uacm.utilities.PathsFXMLS;

public class PerfilController {

    @FXML
    private Button btnEditar1;

    @FXML
    private Button btnEditar11;

    @FXML
    private Button btnEditar2;

    @FXML
    private Button btnEditar21;

    @FXML
    private Button btnEditar211;

    @FXML
    private Button btnEditar2111;

    @FXML
    private ImageView imgBiblioteca;

    @FXML
    private ImageView imgBilletera;

    @FXML
    private ImageView imgBusqueda;

    @FXML
    private ImageView imgCambiarImagen;

    @FXML
    private ImageView imgCarrito;

    @FXML
    private ImageView imgInicio;

    @FXML
    private ImageView imgPerfil;

    @FXML
    private ImageView imgSalir;

    @FXML
    private Pane panBusquedaPerfil;

    @FXML
    private Pane panIconosBibliotecaPerfil;

    @FXML
    private Pane panPrincipalPerfil;

    @FXML
    void clickSalir(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(PathsFXMLS.CERRAR_SESION));
            Parent root = loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal
            dialogStage.setScene(new Scene(root));
            dialogStage.setTitle("Confirmar salida");
            
            // Obtener referencia al controlador del diálogo
            //CerrarSesionController controller = loader.getController();
            //controller.setDialogStage(dialogStage);
            
            dialogStage.showAndWait(); // Muestra y espera hasta que se cierre
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
