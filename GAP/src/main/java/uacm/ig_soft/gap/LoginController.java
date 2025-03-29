/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uacm.ig_soft.gap;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author arman
 */
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

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pn_login.setBackground(new Background(new BackgroundFill(Color.web("#3B2A5E"), new CornerRadii(15), Insets.EMPTY)));

        //cambiando el color de los textos de los textFile
        txf_correo.setStyle("-fx-text-fill: #ffadf4");
        txf_correo.setBackground(new Background(new BackgroundFill(Color.web("#A057B4"), CornerRadii.EMPTY, Insets.EMPTY)));

        paswor_fileUno.setStyle("-fx-text-fill: #ffadf4");
        paswor_fileUno.setBackground(new Background(new BackgroundFill(Color.web("#A057B4"), CornerRadii.EMPTY, Insets.EMPTY)));

        //onbtenemos los valores que se ingresan en el texfile
        paswor_fileUno.setOnAction(event -> {
            String correo = txf_correo.getText();
            String contraseña = paswor_fileUno.getText();
            System.out.println("el correo es:" + correo + "\nla contraseña es: " + contraseña);
        });

        //implementacion del boton Olvido contraseña
        btn_Olvido_Contra.setOnMouseClicked(e -> {

            //creacion de la esena
            Stage stageOlvidoContra = new Stage();

            Parent root;

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("OlvidoContrasena.fxml"));
                root = loader.load();

                Scene scene = new Scene(root);
                stageOlvidoContra.setScene(scene);
                stageOlvidoContra.show();

            } catch (IOException exe) {
                exe.printStackTrace();
            }

        });
        
        

    }

}
