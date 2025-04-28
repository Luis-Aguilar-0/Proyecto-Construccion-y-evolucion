package uacm;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class AgregarTarjetaController {

    @FXML
    private Button btnGuardarTarjeta;

    @FXML
    private Button btnSalir;

    @FXML
    private ImageView imgTarjeta;

    @FXML
    private Label lbTitulo;

    @FXML
    private TextField txtCVV;

    @FXML
    private TextField txtExpiracion;

    @FXML
    private TextField txtNombreTarjeta;

    @FXML
    private TextField txtNumeroTarjeta;

    @FXML
    void GuardarTarjeta(ActionEvent event) {
        try {
    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Exito.fxml"));
            Parent root = loader.load();


            Stage exitoStage = new Stage();
            exitoStage.initStyle(StageStyle.UNDECORATED); 
            exitoStage.setScene(new Scene(root));
            exitoStage.show();

            // Crear una pausa de 2 segundos
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> exitoStage.close());
            delay.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Salir(ActionEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

}
