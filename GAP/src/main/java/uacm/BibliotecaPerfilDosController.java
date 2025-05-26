package uacm;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logic.Juego;
import logic.Usuario;
import persistencia.Sesion;

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
    @FXML 
    private Button bt_pagAnteriorDos;
    @FXML
    private Button bt_pagSiguienteDos;

    private int numPaginas = 0;
    private int indexPagina = 0; // me dice en que pagina estoy parado
    private List<ImageView> listaImageViews = new ArrayList<ImageView>();
    private List<List<Juego>> pagGames = new ArrayList<>();

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

        // obtenemos el usuario que inicio secion
        Usuario usuario = Sesion.getUsuario();
        // obtenemos los juegos del usuario
        usuario.setJuegos(Sesion.getJuegosUsuario());

        if (usuario.getJuegos() != null) {// verifica si el usuario tien juegos
            // obtenemos el numero de juegos que tiene el usuario
            int numJuegos = usuario.getJuegos().size();
            // calculamos el numero de paginas en base al numero de juegos que posee el
            // usuario
            numPaginas = (numJuegos / 12) + 1;

            // llenando las listas con los juegos
            int index = 0;
            int juegosXPagina = 12;

            for (int i = 0; i < numPaginas; i++) {

                List<Juego> Listjuegos = new ArrayList<>();
                for (int j = index; j < juegosXPagina && j < numJuegos; j++) {
                    Listjuegos.add(usuario.getJuegos().get(j));
                    index++;
                }
                juegosXPagina += 12;
                pagGames.add(Listjuegos);
            }

            // se llena lista con las ImageViews
            listaImageViews.add(im_gameUno);
            listaImageViews.add(im_gameDos);
            listaImageViews.add(im_gameTres);
            listaImageViews.add(im_gameCuatro);
            listaImageViews.add(im_gameCinco);
            listaImageViews.add(im_gameSeis);
            listaImageViews.add(im_gameSiete);
            listaImageViews.add(im_gameOcho);
            listaImageViews.add(im_gameNueve);
            listaImageViews.add(im_gameDies);
            listaImageViews.add(im_gameOnce);
            listaImageViews.add(im_gameDoce);

            indexPagina = 0;// se asigana la pagina cero
            // cargando las primeras 12 imagenes
            for (int i = 0; i < numJuegos && i < 12; i++) {
                Image imagen = new Image(getClass().getResource(pagGames.get(indexPagina).get(i).getImagenes()[0]).toExternalForm());// Se crea una imagen con la portada del juego
                listaImageViews.get(i).setImage(imagen);// se cargan las imagenes en las ImageViews
            }

            // estableciendo el scroll en la parte superior
            sC_panelBiblioDos.setVvalue(0);
            Platform.runLater(() -> sC_panelBiblioDos.setVvalue(0));

        } else {
            System.out.println("no hay jugos");
        }

        bt_pagSiguienteDos.setOnMouseClicked(event -> {

            if (!(indexPagina == numPaginas) && Sesion.getJuegosUsuario().size() > 12) {//verifica que no se pase de paginas fuera de rango y que almenos tenga mas de 12 juegos para pasar de pagina
                indexPagina++;
                cambioPagina();
            }
            
        });

        bt_pagAnteriorDos.setOnMouseClicked(event -> {

            if (!(indexPagina == 0 ) && Sesion.getJuegosUsuario().size() > 12) {
                indexPagina--;
                cambioPagina();
            }

        });

    }


    private void cambioPagina() {

        // limpia el contenido de la imagenViews
        for (int i = 0; i < listaImageViews.size(); i++) {
            listaImageViews.get(i).setImage(null);
        }
        //se cargan las imagenes dependiendo de la pagina en la que estoy definido por indexPagina
        for (int i = 0; i < pagGames.get(indexPagina).size(); i++) {
            Image imagen = new Image(getClass().getResource(pagGames.get(indexPagina).get(i).getImagenes()[0]).toExternalForm());// se obtiene la la portada y se crea una imagen
            listaImageViews.get(i).setImage(imagen);// se asignan las imagenes a las Imageviews
        }
        sC_panelBiblioDos.setVvalue(0);
        Platform.runLater(() -> sC_panelBiblioDos.setVvalue(0));
    }

}
