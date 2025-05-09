package uacm;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BibliotecaPerfilDosController implements Initializable {
    @FXML
    private ScrollPane sC_panelBiblioDos;

    @FXML
    private AnchorPane aC_panelJuegosBiblioDos;

    @FXML
    private ImageView im_gameUno;

    @FXML
    private ImageView im_gameDos;

    @FXML
    private ImageView im_gameTres;

    @FXML
    private ImageView im_gameCuatro;

    @FXML
    private ImageView im_gameCinco;

    @FXML
    private ImageView im_gameSeis;

    @FXML
    private ImageView im_gameSiete;

    @FXML
    private ImageView im_gameOcho;

    @FXML
    private ImageView im_gameNueve;

    @FXML
    private ImageView im_gameDies;

    @FXML
    private ImageView im_gameOnce;

    @FXML
    private ImageView im_gameDoce;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    
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

}
