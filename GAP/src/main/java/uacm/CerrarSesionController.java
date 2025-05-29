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

    // Variable para guardar una referencia a la ventana de Perfil.
    private Stage perfilStage;
    // Variable para guardar una referencia al controlador de la pantalla de Perfil.
    private Perfil2Controller perfil2Controller;

    private InicioGapController inicioGAPController;

    // Método para establecer el controlador de la pantalla de Perfil.
    public void setPerfil2Controller(Perfil2Controller controller) {
        this.perfil2Controller = controller;
    }
    // Método para obtener el controlador de la pantalla de Perfil.
    public void setPerfilStage(Stage perfilStage) {
        this.perfilStage = perfilStage;
    }

    public void setInicioGAPController(InicioGapController controller) {
        this.inicioGAPController = controller;
    }

    @FXML
    public void initialize() {
        // Configura los eventos de los botones para cerrar sesión
        btnSalirSi.setOnMouseClicked(event -> {
            // cierra la ventana de confirmación de cierre de sesión
            Stage stage = (Stage) btnSalirSi.getScene().getWindow();
            stage.close();
            // Cierra la ventana perfil, si existe una referencia
            if (perfilStage != null) {
                perfilStage.close();
            }
            persistencia.Sesion.cerrarUsuario(); 
            // abre la ventana de inicio de sesión
            // y carga el controlador de la ventana de inicio de sesión
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Login.fxml"));
                // Carga el controlador de la ventana de inicio de sesión
                Parent root = loader.load();
                Stage loginStage = new Stage();
                stage.setResizable(false);
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
