package uacm;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logic.Usuario;
import uacm.utilities.PathsImages;

public class BilbliotecaPerfilController implements Initializable {
    @FXML
    private Button bt_pagSiguiente;
    @FXML
    private Button bt_pagAnterior;
    @FXML
    private ImageView im_gameTres;
    @FXML
    private ImageView im_gemeCuatro;
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
    @FXML
    private ImageView im_gameUno;
    @FXML
    private ImageView im_gameDos;
    @FXML
    private ScrollPane sC_panel;
    @FXML
    private AnchorPane aC_panelJuegos;
    @FXML
    private AnchorPane apane_principal;
    @FXML
    private ImageView img_logo;

    public PathsImages images;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Usuario usuario = new Usuario();

        usuario.setJuegos(PathsImages.games);
        String[] imagenes = usuario.getJuegos().get(0).getImagenes();

        Image imagen = new Image(getClass().getResource(imagenes[0]).toExternalForm());

        System.out.println(imagenes[0]);

        im_gameUno.setImage(imagen);


      
    }

    

}