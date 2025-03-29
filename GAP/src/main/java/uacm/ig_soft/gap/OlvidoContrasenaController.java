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
      
        
        //cambio de color al Pane                                          //cambio de color      //se redondean las esquinas
        pane_OlviContrasena.setBackground(new Background(new BackgroundFill(Color.web("#3B2A5E"), new CornerRadii(15), Insets.EMPTY)));
        
        //cambio de color al backgroun de los textFile de correo y contraseña nueva
        txt_nuevaContra.setBackground(new Background(new BackgroundFill(Color.web("#3B2A5E"), CornerRadii.EMPTY, Insets.EMPTY)));
        txt_correoOlviConta.setBackground(new Background(new BackgroundFill(Color.web("#3B2A5E"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        //cambio de color a el texto que se ingresa en el textFile
        txt_correoOlviConta.setStyle("-fx-text-fill: #ffadf4");
        txt_nuevaContra.setStyle("-fx-text-fill: #ffadf4");
        
        //obtencion de los datos
        btn_actualizaContra.setOnMouseClicked(e ->{
            
            String correo = txt_correoOlviConta.getText();
            String contrasena = txt_nuevaContra.getText();
            
            System.out.println(correo + "\n" + contrasena);
            
        });
        
        
        
    }    
    
}
