package uacm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import logic.Juego;
import logic.Usuario;
import persistencia.Sesion;
import uacm.utilities.PathsImages;

/**
 *
 * @author Frncs.Fox
 */
public class InicioGapController implements Initializable {

    @FXML
    private ImageView imgInicio;
    @FXML
    private Button botonBiblioteca;
    @FXML
    private Button btnDerecha_play;
    @FXML
    private Button btnIzquierda_play;
    @FXML
    private ScrollPane carrucel_scPn_play;
    @FXML
    private ScrollPane carrucel_scPn_box;
    @FXML
    private Button btnDerecha_box;
    @FXML
    private Button btnIzquierda_box;
    @FXML
    private ScrollPane carrucel_scPn_nin;
    @FXML
    private Button btnDerecha_nin;
    @FXML
    private Button btnIzquierda_nin;
    @FXML
    private Button bt_carrito;
    private final double speed_scroll = 0.1;
    @FXML
    private MenuButton menuPerfil_btn;
    @FXML
    private Button categorias_btn;
    @FXML
    private ImageView img1Play;
    @FXML
    private ImageView img2Play;
    @FXML
    private ImageView img3Play;
    @FXML
    private ImageView img4Play;
    @FXML
    private ImageView img5Play;
    @FXML
    private ImageView img6Play;
    @FXML
    private ImageView img1Xbox;
    @FXML
    private ImageView img2Xbox;
    @FXML
    private ImageView img3Xbox;
    @FXML
    private ImageView img4Xbox;
    @FXML
    private ImageView img5Xbox;
    @FXML
    private ImageView img6Xbox;
    @FXML
    private ImageView img1Nin;
    @FXML
    private ImageView img2Nin;
    @FXML
    private ImageView img3Nin;
    @FXML
    private ImageView img4Nin;
    @FXML
    private ImageView img5Nin;
    @FXML
    private ImageView img6Nin;
    @FXML
    private MenuItem verPerfil_Item;
    @FXML
    private MenuItem cerrarSesion_Item;
    @FXML
    private Button recarga_bttn;
    @FXML
    private Label label_coins;
    @FXML
    private BorderPane id_borderPane;

    @FXML
    private void moverIzquierdaPlay() {
        double nuevaPosicion = carrucel_scPn_play.getHvalue() - speed_scroll;
        carrucel_scPn_play.setHvalue(Math.max(nuevaPosicion, 0));
    }

    @FXML
    private void moverDerechaPlay() {
        double nuevaPosicion = carrucel_scPn_play.getHvalue() + speed_scroll;
        carrucel_scPn_play.setHvalue(Math.min(nuevaPosicion, 1));
    }

    @FXML
    private void moverIzquierdaBox() {
        double nuevaPosicion = carrucel_scPn_box.getHvalue() - speed_scroll;

        carrucel_scPn_box.setHvalue(Math.max(nuevaPosicion, 0));
    }

    @FXML
    private void moverDerechaBox() {
        double nuevaPosicion = carrucel_scPn_box.getHvalue() + speed_scroll;

        carrucel_scPn_box.setHvalue(Math.min(nuevaPosicion, 1));
    }

    @FXML
    private void moverIzquierdaNin() {
        double nuevaPosicion = carrucel_scPn_nin.getHvalue() - speed_scroll;

        carrucel_scPn_nin.setHvalue(Math.max(nuevaPosicion, 0));
    }

    @FXML
    private void moverDerechaNin() {
        double nuevaPosicion = carrucel_scPn_nin.getHvalue() + speed_scroll;

        carrucel_scPn_nin.setHvalue(Math.min(nuevaPosicion, 1));
    }

    public void abrirVentana(String rutaFXML, MouseEvent event, String tituloVentana) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle(tituloVentana);
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();

            Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ventanaActual.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirVentana2(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void cambiarVentana2(String rutaFXML, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();

            Object fuente = event.getSource();
            Stage ventanaActual = null;

            if (fuente instanceof Node) {
                ventanaActual = (Stage) ((Node) fuente).getScene().getWindow();
            } else if (fuente instanceof MenuItem) {
                Window ventanaMenu = ((MenuItem) fuente).getParentPopup().getOwnerWindow();
                if (ventanaMenu instanceof Stage) {
                    ventanaActual = (Stage) ventanaMenu;
                }
            }

            if (ventanaActual != null) {
                ventanaActual.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void irCarrito(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/Carrito.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Carrito de Compras");
            stage.setScene(new Scene(root));
            stage.show();
            // Obtener la fuente del evento, el boton
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarImagenPerfil() {
        Usuario u = Sesion.getUsuario();
        if (u != null && u.getImagenPerfil() != null) {
            Image image = new Image(new ByteArrayInputStream(u.getImagenPerfil()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(70);
            imageView.setFitHeight(70);
            imageView.setPreserveRatio(true);

            menuPerfil_btn.setGraphic(imageView);
        } else {
            Image image = new Image("file:src/main/resources/imagenes/imagesPerfil/perfil4.png");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(70);
            imageView.setFitHeight(70);
            imageView.setPreserveRatio(true);

            menuPerfil_btn.setGraphic(imageView);
        }
    }

    private void mostrarCoins() {
        Usuario u = Sesion.getUsuario();
        if (u != null && u.getAjoloCoins() != 0) {
            label_coins.setText(u.getAjoloCoins().toString() + " Ax");
        } else {
            label_coins.setText("0 Ax");
        }
    }
    //cierra la el stage actual
    private void cerrarVentana(Button boton) {
        Stage ventanaActual = (Stage) boton.getScene().getWindow();
        ventanaActual.close();
    }
    //busca el jugo por su nobre en la  lista statica 
    private Juego getJuegoPorNombre(String nombre) {
        List<Juego> juegos = PathsImages.games; // obtengo los juegos

        for (Juego j : juegos) {
            if (j.getNombreJuego().equalsIgnoreCase(nombre)) {
                return j;
            }
        }
        return null;
    }
    //Me permite guardar el juego que se cargara en la pagina de juego
    private void paginaJuego(Juego juego) {
        if (juego != null) {
            Sesion.setJuegoPagina(juego);
        } else {
            System.out.println(juego);
        }
    }

    @FXML
    private void cerrarVentana(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/CerrarSesion.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
             stage.setTitle("Cerrar Sesión");
           
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            
            stage.initModality(Modality.APPLICATION_MODAL);
            
            stage.initOwner(id_borderPane.getScene().getWindow());
           

            CerrarSesionController cerrarCtrl = loader.getController();
            cerrarCtrl.setInicioGAPController(this);
            // Pasa la referencia al Stage de perfil para que pueda cerrarse
            cerrarCtrl.setPerfilStage((Stage) id_borderPane.getScene().getWindow());

             stage.showAndWait(); // Espera hasta que se cierre
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarImagenPerfil();
        mostrarCoins();
        Sesion.setPantallaOrigen("/fxmls/InicioGap.fxml");

        btnIzquierda_play.setOnAction(e -> moverIzquierdaPlay());

        btnDerecha_play.setOnAction(e -> moverDerechaPlay());

        btnIzquierda_box.setOnAction(e -> moverIzquierdaBox());

        btnDerecha_box.setOnAction(e -> moverDerechaBox());

        btnIzquierda_nin.setOnAction(e -> moverIzquierdaNin());

        btnDerecha_nin.setOnAction(e -> moverDerechaNin());

        // Abre la pagina de cada juego mostrado en pantalla
        // Juegos Playstation
        img1Play.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("The Last of Us Part I"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "The Last Of Us");
        });

        img2Play.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("God Of War Ragnarök"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "God Of War");
        });

        img3Play.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("UNCHARTED: Colección Legado de ladrones"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Uncharted");
        });
        img4Play.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Horizon: Zero Dawn"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Horizon");
        });
        img5Play.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Marvels Spider-Man: Miles Morales"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Spider Man");
        });
        img6Play.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Returnal"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Returnal");
        });

        // Juegos XBox
        img1Xbox.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Mortal Kombat 1"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Mortal Kombat 1");
        });
        img2Xbox.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Grand Theft Auto V"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Grand Theft Auto");
        });
        img3Xbox.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("ELDEN RING"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Elden Ring");
        });
        img4Xbox.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Cyberpunk 2077"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Cyber Punk");
        });
        img5Xbox.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Hogwarts Legacy"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Hogwarts Legacy");
        });
        img6Xbox.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Battlefield V"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Battlefield V");
        });

        // Juegos Nintendo
        img1Nin.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Super Mario Party Jamboree"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Mario Party");
        });
        img2Nin.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("The Legend of Zelda: Tears of the Kingdom"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Zelda: Tears of the kindom");
        });
        img3Nin.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Pokémon Violet"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Pokémon Purpura");
        });
        img4Nin.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Super Mario Odyssey"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Super Mario Odyssey");
        });
        img5Nin.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Super Smash Bros. Ultimate"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Super Smash Bros");
        });
        img6Nin.setOnMouseClicked(eh -> {
            paginaJuego(getJuegoPorNombre("Mario Kart 8 Deluxe"));
            abrirVentana("/fxmls/Pagina_juego.fxml", eh, "Mario Kart 8");
        });

        categorias_btn.setOnAction(eh -> {
            cambiarVentana2("/fxmls/Categorias.fxml", eh);
        });

        botonBiblioteca.setOnAction(eh -> {
            cerrarVentana(botonBiblioteca);
            // abrirVentana("/fxmls/BibliotecaPerfil.fxml", "Biblioteca"); } ;
            //cambiarVentana2("/fxmls/BibliotecaPerfil.fxml", eh);
        });

        verPerfil_Item.setOnAction(eh -> {
            cambiarVentana2("/fxmls/Perfil2.fxml", eh);
        });

        cerrarSesion_Item.setOnAction(eh -> {
            cerrarVentana(eh);
            //abrirVentana2("/fxmls/CerrarSesion.fxml");
        });

        recarga_bttn.setOnAction(eh -> {
            cambiarVentana2("/fxmls/RecargaAxolotl.fxml", eh);
        });

    }

    // MÉTODO NUEVO: Específico para abrir Pagina_juego.fxml y pasarle el objeto
    // Juego
    /*
     * public void abrirPaginaJuegoConDatos(MouseEvent event, Juego
     * juegoSeleccionado) {
     * if (juegoSeleccionado == null) {
     * System.err.
     * println("InicioGapController: No se puede abrir la página del juego, juegoSeleccionado es null."
     * );
     * // Opcional: Mostrar una alerta al usuario
     * return;
     * }
     * try {
     * FXMLLoader loader = new
     * FXMLLoader(getClass().getResource("/fxmls/Pagina_juego.fxml"));
     * Parent root = loader.load();
     * 
     * Pagina_juegoController controller = loader.getController();
     * if (controller != null) {
     * controller.setJuego(juegoSeleccionado); // Aquí se pasa el objeto Juego
     * } else {
     * System.err.
     * println("Error crítico: No se pudo obtener el controlador para Pagina_juego.fxml"
     * );
     * }
     * 
     * Stage nuevaVentana = new Stage();
     * nuevaVentana.setTitle(juegoSeleccionado.getNombreJuego());
     * nuevaVentana.setScene(new Scene(root));
     * nuevaVentana.show();
     * 
     * // Por defecto, no cerramos la ventana de InicioGap.
     * // Si quieres cerrarla, descomenta la siguiente línea:
     * // ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
     * 
     * } catch (IOException e) {
     * System.err.println("Error al cargar FXML /fxmls/Pagina_juego.fxml: " +
     * e.getMessage());
     * e.printStackTrace();
     * } catch (Exception e) {
     * System.err.println("Error inesperado al abrir la página del juego '" +
     * juegoSeleccionado.getNombreJuego() + "': " + e.getMessage());
     * e.printStackTrace();
     * }
     * }
     */

}
