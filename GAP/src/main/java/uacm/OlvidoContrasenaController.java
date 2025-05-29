/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uacm;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import logic.Usuario;
import persistencia.UsuarioDAO;


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
    @FXML
    private Label lb_cambioExitoso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //obtencion de los datos
        btn_actualizaContra.setOnMouseClicked(e ->{
            Usuario us = new Usuario();
            try {
                UsuarioDAO usDAO = new UsuarioDAO();
                us = usDAO.buscaUsuario(txt_correoOlviConta.getText());
                if(us != null){
                    usDAO.updateContrasena(us.getId(), txt_nuevaContra.getText());
                    lb_cambioExitoso.setText("Cambio exitoso....");
                    lb_cambioExitoso.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");  
                }else{
                    lb_cambioExitoso.setText("Usiario no registrado, porfavor verifique el correo electronico.");
                    lb_cambioExitoso.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");  
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(OlvidoContrasenaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }    
    
}
