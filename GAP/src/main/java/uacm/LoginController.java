package uacm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private Pane pn_login;
    @FXML
    private TextField txf_correo;
    @FXML
    private Button btn_Olvido_Contra;
    @FXML
    private Button bt_Registrate;
    @FXML
    private PasswordField paswor_fileUno;
    @FXML
    private TextField tx_vistaContra;
    @FXML
    private Button btn_verContra;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pn_login.setBackground(new Background(new BackgroundFill(Color.web("#3B2A5E"), new CornerRadii(15), Insets.EMPTY)));

        txf_correo.setStyle("-fx-text-fill: #ffadf4");
        txf_correo.setBackground(
                new Background(new BackgroundFill(Color.web("#A057B4"), CornerRadii.EMPTY, Insets.EMPTY)));

        paswor_fileUno.setStyle("-fx-text-fill: #ffadf4");
        paswor_fileUno.setBackground(new Background(new BackgroundFill(Color.web("#A057B4"), CornerRadii.EMPTY, Insets.EMPTY)));

        tx_vistaContra.setStyle("-fx-text-fill: #ffadf4");
        tx_vistaContra.setBackground(new Background(new BackgroundFill(Color.web("#A057B4"), CornerRadii.EMPTY, Insets.EMPTY)));

        paswor_fileUno.setOnAction(event -> {
            // a qui va el codigo para que carge la pantalla principal
            String correo = txf_correo.getText();
            String contraseña = paswor_fileUno.getText();
            System.out.println("el correo es:" + correo + "\nla contraseña es: " + contraseña);
        });

        btn_Olvido_Contra.setOnMouseClicked(e -> {
            Stage stageOlvidoContra = new Stage();
            Parent root;

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/OlvidoContrasena.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                stageOlvidoContra.setScene(scene);
                stageOlvidoContra.show();
            } catch (IOException exe) {
                exe.printStackTrace();
            }
        });

        // oculta el tx_vistaContra
        if (paswor_fileUno.getText() != null || paswor_fileUno == null) {
            tx_vistaContra.setVisible(false);
        }

        // funcionalidad del boton mostrar contraseña
        btn_verContra.setOnMouseClicked(event -> {

            Timer timer = new Timer();
            TimerTask tareaUno = new TimerTask() {
                public void run() {
                    // oculta la contraaseña
                    tx_vistaContra.setVisible(false);
                    // mostramos la contraseña en formato pasword
                    paswor_fileUno.setVisible(true);
                }
            };

            // obtenemos lo que esta en el paswor file
            tx_vistaContra.setText(paswor_fileUno.getText());
            // ocultamos el paswor file
            paswor_fileUno.setVisible(false);
            // mostramos la contraseña
            tx_vistaContra.setVisible(true);
            System.out.println("la tarea esta echa");
            timer.schedule(tareaUno, 5000);

        });

    }
}
