package uacm;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BilleteraPerfilController {

    @FXML
    private Button btnAgregarSaldo;

    @FXML
    private Button btnAgregarTarjeta;

    @FXML
    private Label lbSaldo;

    @FXML
    private Label lbSaldoCuenta;

    @FXML
    private Label lbTarjetas;

    private Perfil2Controller perfil2Controller;

    public void setPerfil2Controller(Perfil2Controller controller) {
        this.perfil2Controller = controller;
    }

    @FXML
    public void initialize() {
        btnAgregarTarjeta.setOnMouseClicked(event -> abrirVentanaAgregarTarjeta());
    }

    private void abrirVentanaAgregarTarjeta() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/AgregarTarjeta.fxml"));
            Parent root = loader.load();
            
            Stage stageAgregarTarjeta = new Stage();
            stageAgregarTarjeta.initModality(Modality.APPLICATION_MODAL); 
            stageAgregarTarjeta.setScene(new Scene(root));
            stageAgregarTarjeta.setTitle("Agregar Tarjeta de Crédito");
            
            stageAgregarTarjeta.showAndWait(); 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
