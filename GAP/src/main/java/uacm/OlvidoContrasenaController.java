/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uacm;

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
public class OlvidoContrasenaController implements Initializable {

    @FXML
    private Pane pane_OlviContrasena;
    @FXML
    private TextField txt_correoOlviConta;
    @FXML
    private TextField txt_nuevaContra;
    @FXML
    private Button btn_actualizaContra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //obtencion de los datos
        btn_actualizaContra.setOnMouseClicked(e ->{
            
            String correo = txt_correoOlviConta.getText();
            String contrasena = txt_nuevaContra.getText();
            
            System.out.println(correo + "\n" + contrasena);
            
        });

    }    
    
}
