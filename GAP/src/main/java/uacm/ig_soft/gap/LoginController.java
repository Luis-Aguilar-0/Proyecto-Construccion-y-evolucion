/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uacm.ig_soft.gap;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
