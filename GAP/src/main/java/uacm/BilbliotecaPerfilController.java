package uacm;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logic.Usuario;
import persistencia.JuegoDAO;
import persistencia.Sesion;
import uacm.utilities.PathsImages;
import javafx.scene.control.Button;

public class BilbliotecaPerfilController implements Initializable {

    @FXML
    private ImageView img_logo;
    @FXML
    private Button bt_inicio;
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

    private int indice = 0;

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

    // public PathsImages images;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // obtenemos el usuario que inicio secion
        Usuario usuario = Sesion.getUsuario();

        usuario.setJuegos(PathsImages.games);

        String[] imagenes = null;
        Image imagen = null;
        List<Image> listImages = new ArrayList<Image>();
        List<ImageView> listaImageViews = new ArrayList<ImageView>();

        listaImageViews.add(im_gameUno);
        listaImageViews.add(im_gameDos);
        listaImageViews.add(im_gameTres);
        listaImageViews.add(im_gemeCuatro);
        listaImageViews.add(im_gameCinco);
        listaImageViews.add(im_gameSeis);
        listaImageViews.add(im_gameSiete);
        listaImageViews.add(im_gameOcho);
        listaImageViews.add(im_gameNueve);
        listaImageViews.add(im_gameDies);
        listaImageViews.add(im_gameOnce);
        listaImageViews.add(im_gameDoce);

        for (int i = 0; i < usuario.getJuegos().size(); i++) {
            // obtienes los juegos del usario //primer juego //las imagenes del juego
            imagenes = usuario.getJuegos().get(i).getImagenes();
            // obtenemos solo la portada del juego
            System.out.println(imagenes[0]);
            imagen = new Image(getClass().getResource(imagenes[0]).toExternalForm());
            // agregamos la imagen con la portada a una lista de imagenes
            listImages.add(imagen);
            // asignamos a cada una de las imagenView la portada
            // listaImageViews.get(i).setImage(listImages.get(i));
        }

        //Asignamos las imagenes a las imageViews
        for (int i = 0; i < 12; i++) {
            listaImageViews.get(i).setImage(listImages.get(i));
            indice++;
        }

        System.out.println(indice);

        bt_pagSiguiente.setOnMouseClicked(event -> {
            int indexListaimageViews = 0;
            for (int i = 12; i < 24; i++) {
                listaImageViews.get(indexListaimageViews).setImage(listImages.get(i));
                indexListaimageViews++;
                indice++;
            }
            System.out.println(indice);
        });

        bt_pagAnterior.setOnMouseClicked(event -> {
            int indexListaimageViews = 0;
            for (int i = 23; i >= 12; i--) {
                listaImageViews.get(indexListaimageViews).setImage(listImages.get(i));
                indexListaimageViews++;
                indice--;
            }
            System.out.println(indice);
        });

    }

}
