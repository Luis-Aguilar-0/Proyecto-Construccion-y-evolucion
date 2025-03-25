/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uacm.ig_soft.gap;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
    private TextField txf_Contraseña;
    @FXML
    private Button btn_Olvido_Contra;
    @FXML
    private Button bt_Registrate;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        pn_login.setBackground(new Background(new BackgroundFill(Color.web("#3B2A5E"), new CornerRadii(15), Insets.EMPTY)));
        
        //onbtenemos los valores que se ingresan en el texfile
        txf_Contraseña.setOnAction(event ->{
            String correo = txf_correo.getText();
            String contraseña = txf_Contraseña.getText();
            System.out.println("el correo es:" + correo + "\nla contraseña es: "+ contraseña);
        });
       
        
       
       
    }    
    
}
