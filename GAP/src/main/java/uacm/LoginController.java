package uacm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchoPane;
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

        paswor_fileUno.setOnAction(event -> {
            // a qui va el codigo para que carge la pantalla principal
            String correo = txf_correo.getText();
            String contraseña = paswor_fileUno.getText();
            System.out.println("el correo es:" + correo + "\nla contraseña es: " + contraseña);
        });

        //carga de la pantalla olvido contaseña
        btn_Olvido_Contra.setOnMouseClicked(e -> {

            Stage stageOlvidoContra = new Stage();
            //stageOlvidoContra.initStyle(StageStyle.UNDECORATED);//se elimina la barra  por defecto
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
        if (paswor_fileUno.getText() != null || paswor_fileUno == null) {//se oculta en cualquier caso
            tx_vistaContra.setVisible(false);
        }

        // funcionalidad del boton mostrar contraseña
        btn_verContra.setOnMouseClicked(event -> {

            Timer timer = new Timer(); //se crea el objeto timer 
            TimerTask tareaUno = new TimerTask() {//se crea una nueva tarea cada vez que se pulsa el boton
                public void run() { //la tarea a realizar
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
            
            timer.schedule(tareaUno, 5000);//cuando se pulsa el boton el timer espera cinco segundo y ejecuta la tarea

        });

        bt_Registrate.setOnMouseClicked(e -> {
            Stage stageOlvidoContra = new Stage();
            Parent root;

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Registro.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                stageOlvidoContra.setScene(scene);
                stageOlvidoContra.show();
            } catch (IOException exe) {
                exe.printStackTrace();
            }
        });

         
        //ajustando el tamaño de la scena cuando se modifica el tamaño de la scene
        //ajuste en el eje x                 estos parametros representan en ancho del pane 
       anchoPane.widthProperty().addListener((anchoPane,anchoAnterior,nuevoAncho)->{
                                //se resta el nuevo ancho con el ancho del pane que yo define 
            pn_login.setLayoutX((nuevoAncho.doubleValue()- pn_login.getPrefWidth())/2);//se divide entre dos para que este centrado  
       } );
       //se ajusta en el eje y
       anchoPane.heightProperty().addListener((anchoPane,anchoAnterior,nuevoAncho)->{
            pn_login.setLayoutY((nuevoAncho.doubleValue()-pn_login.getPrefHeight()) /2);
       });
       
    }
}
