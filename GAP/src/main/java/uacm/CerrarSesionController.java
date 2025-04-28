package uacm;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CerrarSesionController {

    @FXML
    private Button BtnSalirNo;

    @FXML
    private Button btnSalirSi;

    private Stage perfilStage;

    private Perfil2Controller perfil2Controller;

    public void setPerfil2Controller(Perfil2Controller controller) {
        this.perfil2Controller = controller;
    }

    public void setPerfilStage(Stage perfilStage) {
        this.perfilStage = perfilStage;
    }

    @FXML
    public void initialize() {
        btnSalirSi.setOnMouseClicked(event -> {
            Stage stage = (Stage) btnSalirSi.getScene().getWindow();
            stage.close();

            if (perfilStage != null) {
                perfilStage.close();
            }

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Login.fxml"));
                Parent root = loader.load();
                Stage loginStage = new Stage();
                Scene scene = new Scene(root);
                loginStage.setScene(scene);
                loginStage.show();
            } catch (IOException exe) {
                exe.printStackTrace();
            }
        });

        BtnSalirNo.setOnMouseClicked(event -> {
            Stage stage = (Stage) BtnSalirNo.getScene().getWindow();
            stage.close();
        });
    }
}
