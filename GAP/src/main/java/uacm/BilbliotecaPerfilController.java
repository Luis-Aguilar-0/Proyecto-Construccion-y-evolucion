package uacm;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class BilbliotecaPerfilController implements Initializable {

    @FXML
    private ScrollPane scrolPanel;
    @FXML 
    private AnchorPane anchoPaneB;
    @FXML
    private TextField texFil_busqueda;

    @FXML
    private void mostrarPerfil() {
        if (perfil2Controller != null) {
            perfil2Controller.muestraPerfil();
        }
    }
    private Perfil2Controller perfil2Controller;

    // Método para recibir la referencia al controlador principal
    public void setPerfil2Controller(Perfil2Controller controller) {
        this.perfil2Controller = controller;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        
      
    }



    
}